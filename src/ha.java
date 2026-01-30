package src;

/**
 * @author: Yuan Yuqing
 * @date: 2025-08-27 15:59
 */
import java.util.Objects;

/**
 * 简易版HashMap实现（数组+链表处理哈希冲突）
 */
class SimpleHashMap<K, V> {  // 移除了public修饰符
    // 内部节点类：存储键值对，形成链表
    static class Node<K, V> {
        final int hash;    // 哈希值（缓存，避免重复计算）
        final K key;       // 键
        V value;           // 值
        Node<K, V> next;   // 下一个节点（处理哈希冲突）

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    // 默认初始容量（必须是2的幂）
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    // 默认负载因子
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    Node<K, V>[] table;  // 哈希表数组（存储链表头节点）
    int size;            // 实际元素数量
    int threshold;       // 扩容阈值（容量 * 负载因子）
    float loadFactor;    // 负载因子

    // 构造方法
    public SimpleHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        this.table = new Node[DEFAULT_INITIAL_CAPACITY];
    }

    /**
     * 计算键的哈希值（简化版）
     */
    static final int hash(Object key) {
        int h;
        // key为null时哈希值为0，否则用key的hashCode高16位异或低16位（减少碰撞）
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * 添加键值对
     */
    public V put(K key, V value) {
        return putVal(hash(key), key, value);
    }

    /**
     * 实际执行添加的逻辑
     */
    private V putVal(int hash, K key, V value) {
        Node<K, V>[] tab = table;
        int n = tab.length;
        int index;  // 计算索引

        // 1. 计算索引位置（n-1 & hash 等价于 hash % n，前提是n为2的幂）
        index = (n - 1) & hash;
        Node<K, V> p = tab[index];

        // 2. 处理索引位置的链表
        if (p == null) {
            // 索引位置为空，直接插入新节点
            tab[index] = new Node<>(hash, key, value, null);
        } else {
            // 索引位置已有节点，遍历链表
            Node<K, V> e;
            K k;
            // 2.1 检查头节点是否相同（哈希+键相等）
            if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k)))) {
                e = p;
            } else {
                // 2.2 遍历链表找相同key，或到链表尾部
                while ((e = p.next) != null) {
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
                        break;  // 找到相同key的节点
                    }
                    p = e;  // 移动到下一个节点
                }
                // 2.3 未找到相同key，在链表尾部插入新节点
                if (e == null) {
                    p.next = new Node<>(hash, key, value, null);
                }
            }

            // 3. 若存在相同key的节点，更新value
            if (e != null) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;  // 返回旧值
            }
        }

        // 4. 元素数量+1，检查是否需要扩容
        size++;
        if (size > threshold) {
            resize();  // 扩容
        }
        return null;  // 新增节点时返回null
    }

    /**
     * 获取键对应的值
     */
    public V get(Object key) {
        Node<K, V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }

    /**
     * 实际执行查找的逻辑
     */
    private Node<K, V> getNode(int hash, Object key) {
        Node<K, V>[] tab = table;
        Node<K, V> first, e;
        int n = tab.length;
        K k;

        // 1. 计算索引，检查对应位置是否有链表
        if (tab != null && n > 0 && (first = tab[(n - 1) & hash]) != null) {
            // 2. 检查头节点
            if (first.hash == hash && ((k = first.key) == key || (key != null && key.equals(k)))) {
                return first;
            }
            // 3. 遍历链表查找
            if ((e = first.next) != null) {
                do {
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
                        return e;
                    }
                } while ((e = e.next) != null);
            }
        }
        return null;  // 未找到
    }

    /**
     * 扩容（容量翻倍，重新计算所有节点的索引）
     */
    private void resize() {
        Node<K, V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap, newThr = 0;

        // 1. 计算新容量（翻倍）
        if (oldCap > 0) {
            newCap = oldCap << 1;  // 左移1位等价于*2
            newThr = oldThr << 1;  // 阈值也翻倍
        } else {
            // 初始化时的扩容（此处简化处理）
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
        }
        threshold = newThr;

        // 2. 创建新数组
        Node<K, V>[] newTab = new Node[newCap];
        table = newTab;

        // 3. 将旧数组的节点迁移到新数组
        if (oldTab != null) {
            for (int j = 0; j < oldCap; j++) {
                Node<K, V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;  // 帮助GC
                    // 遍历链表迁移节点
                    do {
                        Node<K, V> next = e.next;
                        // 重新计算索引（新容量是旧的2倍，可简化计算）
                        int newIndex = (newCap - 1) & e.hash;
                        // 插入新链表头部（简易处理）
                        e.next = newTab[newIndex];
                        newTab[newIndex] = e;
                        e = next;
                    } while (e != null);
                }
            }
        }
    }

    // 获取当前元素数量
    public int size() {
        return size;
    }

    // 测试
    public static void main(String[] args) {
        SimpleHashMap<String, Integer> map = new SimpleHashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("a", 100);  // 测试覆盖相同key

        System.out.println("size: " + map.size());  // 输出3
        System.out.println("get 'a': " + map.get("a"));  // 输出100
        System.out.println("get 'b': " + map.get("b"));  // 输出2
        System.out.println("get 'd': " + map.get("d"));  // 输出null
    }
}
