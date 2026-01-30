package src;

/**
 * @author: Yuan Yuqing
 * @date: 2025-08-27 16:00
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程安全的HashMap实现
 * 采用分段锁机制提高并发性能
 * @param <K> 键类型
 * @param <V> 值类型
 */
public class ThreadSafeHashMap<K, V> {
    // 分段锁的数量，必须是2的幂
    private static final int DEFAULT_CONCURRENCY_LEVEL = 16;

    // 每个分段的默认初始容量
    private static final int DEFAULT_SEGMENT_CAPACITY = 16;

    // 每个分段的默认负载因子
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    // 存储所有分段
    private final Segment<K, V>[] segments;

    // 分段数量
    private final int concurrencyLevel;

    /**
     * 分段类，每个分段相当于一个小型的HashMap
     */
    static final class Segment<K, V> extends ReentrantLock {
        private static final long serialVersionUID = 1L;

        // 存储元素的数组
        transient Entry<K, V>[] table;

        // 元素数量
        transient int count;

        // 扩容阈值
        int threshold;

        // 负载因子
        final float loadFactor;

        Segment(int initialCapacity, float loadFactor) {
            this.loadFactor = loadFactor;
            this.table = new Entry[initialCapacity];
            this.threshold = (int) (initialCapacity * loadFactor);
        }

        /**
         * 插入键值对
         */
        V put(K key, V value, int hash) {
            lock(); // 加锁
            try {
                int c = count;
                // 如果当前数量超过阈值，进行扩容
                if (c++ > threshold) {
                    rehash();
                }

                Entry<K, V>[] tab = table;
                int index = hash & (tab.length - 1);
                Entry<K, V> first = tab[index];
                Entry<K, V> e = first;

                // 查找是否存在相同的key
                while (e != null && (e.hash != hash || !key.equals(e.key))) {
                    e = e.next;
                }

                V oldValue;
                if (e != null) {
                    // 存在相同的key，更新值
                    oldValue = e.value;
                    e.value = value;
                } else {
                    // 不存在相同的key，插入新节点
                    oldValue = null;
                    tab[index] = new Entry<>(hash, key, value, first);
                    count = c; // 计数+1
                }
                return oldValue;
            } finally {
                unlock(); // 解锁
            }
        }

        /**
         * 获取键对应的值
         */
        V get(K key, int hash) {
            if (count == 0) {
                return null;
            }

            // 不需要加锁，使用volatile保证可见性
            Entry<K, V>[] tab = table;
            int index = hash & (tab.length - 1);
            Entry<K, V> e = tab[index];

            // 遍历链表查找
            while (e != null) {
                if (e.hash == hash && key.equals(e.key)) {
                    return e.value;
                }
                e = e.next;
            }
            return null;
        }

        /**
         * 移除键对应的键值对
         */
        V remove(K key, int hash) {
            lock(); // 加锁
            try {
                Entry<K, V>[] tab = table;
                int index = hash & (tab.length - 1);
                Entry<K, V> e = tab[index];
                Entry<K, V> prev = null;

                // 查找要删除的节点
                while (e != null && (e.hash != hash || !key.equals(e.key))) {
                    prev = e;
                    e = e.next;
                }

                V oldValue = null;
                if (e != null) {
                    oldValue = e.value;
                    if (prev == null) {
                        // 删除头节点
                        tab[index] = e.next;
                    } else {
                        // 删除中间节点
                        prev.next = e.next;
                    }
                    count--; // 计数-1
                }
                return oldValue;
            } finally {
                unlock(); // 解锁
            }
        }

        /**
         * 扩容当前分段
         */
        private void rehash() {
            Entry<K, V>[] oldTable = table;
            int oldCapacity = oldTable.length;

            // 扩容为原来的2倍
            int newCapacity = oldCapacity << 1;
            Entry<K, V>[] newTable = new Entry[newCapacity];

            threshold = (int) (newCapacity * loadFactor);
            table = newTable;

            // 迁移元素到新表
            for (int i = 0; i < oldCapacity; i++) {
                Entry<K, V> e = oldTable[i];
                if (e != null) {
                    oldTable[i] = null; // 帮助GC
                    do {
                        Entry<K, V> next = e.next;
                        int index = e.hash & (newCapacity - 1);
                        e.next = newTable[index];
                        newTable[index] = e;
                        e = next;
                    } while (e != null);
                }
            }
        }

        /**
         * 获取当前分段的元素数量
         */
        int size() {
            return count;
        }
    }

    /**
     * 链表节点，存储键值对
     */
    static class Entry<K, V> {
        final int hash;
        final K key;
        volatile V value; // 使用volatile保证可见性
        Entry<K, V> next;

        Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 构造函数
     */
    public ThreadSafeHashMap() {
        this(DEFAULT_CONCURRENCY_LEVEL, DEFAULT_SEGMENT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public ThreadSafeHashMap(int concurrencyLevel, int initialCapacity, float loadFactor) {
        // 确保并发级别是2的幂
        this.concurrencyLevel = roundUpToPowerOfTwo(concurrencyLevel);

        // 计算每个分段的初始容量
        int perSegmentCapacity = initialCapacity / this.concurrencyLevel;
        if (perSegmentCapacity < DEFAULT_SEGMENT_CAPACITY) {
            perSegmentCapacity = DEFAULT_SEGMENT_CAPACITY;
        }

        // 初始化分段数组
        segments = (Segment<K, V>[]) new Segment[this.concurrencyLevel];
        for (int i = 0; i < segments.length; i++) {
            segments[i] = new Segment<>(perSegmentCapacity, loadFactor);
        }
    }

    /**
     * 将数值向上取整为最接近的2的幂
     */
    private static int roundUpToPowerOfTwo(int val) {
        int highestOneBit = Integer.highestOneBit(val);
        return (highestOneBit == val) ? val : highestOneBit << 1;
    }

    /**
     * 计算键的哈希值
     */
    private static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * 计算分段索引
     */
    private int segmentForHash(int hash) {
        return (hash >>> (32 - Integer.numberOfTrailingZeros(concurrencyLevel)))
                & (concurrencyLevel - 1);
    }

    /**
     * 添加键值对
     */
    public V put(K key, V value) {
        int hash = hash(key);
        int segmentIndex = segmentForHash(hash);
        return segments[segmentIndex].put(key, value, hash);
    }

    /**
     * 获取键对应的值
     */
    public V get(K key) {
        int hash = hash(key);
        int segmentIndex = segmentForHash(hash);
        return segments[segmentIndex].get(key, hash);
    }

    /**
     * 移除键对应的键值对
     */
    public V remove(K key) {
        int hash = hash(key);
        int segmentIndex = segmentForHash(hash);
        return segments[segmentIndex].remove(key, hash);
    }

    /**
     * 获取总元素数量
     */
    public int size() {
        int sum = 0;
        for (Segment<K, V> segment : segments) {
            sum += segment.size();
        }
        return sum;
    }

    /**
     * 判断是否为空
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 获取所有键
     */
    public List<K> keySet() {
        List<K> keys = new ArrayList<>();
        for (Segment<K, V> segment : segments) {
            segment.lock();
            try {
                Entry<K, V>[] tab = segment.table;
                for (int i = 0; i < tab.length; i++) {
                    Entry<K, V> e = tab[i];
                    while (e != null) {
                        keys.add(e.key);
                        e = e.next;
                    }
                }
            } finally {
                segment.unlock();
            }
        }
        return keys;
    }

    // 测试线程安全
    public static void main(String[] args) throws InterruptedException {
        ThreadSafeHashMap<String, Integer> map = new ThreadSafeHashMap<>();
        int threadCount = 10;
        int operationsPerThread = 1000;

        Runnable task = () -> {
            for (int i = 0; i < operationsPerThread; i++) {
                String key = "key" + (i % 10); // 10个不同的key
                map.put(key, i);
                map.get(key);
                if (i % 100 == 0) {
                    map.remove("key" + (i % 10));
                }
            }
        };

        // 创建并启动多个线程
        Thread[] threads = new Thread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        // 等待所有线程完成
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("最终元素数量: " + map.size());
        System.out.println("所有键: " + map.keySet());
    }
}
