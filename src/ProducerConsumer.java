package src;

/**
 * @author: Yuan Yuqing
 * @date: 2025-08-27 15:41
 */
import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    private static final int MAX_SIZE = 3; // 缓冲区最大容量
    private final Queue<Integer> buffer = new LinkedList<>();

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                // 如果缓冲区满了，生产者等待
                while (buffer.size() == MAX_SIZE) {
                    System.out.println("如果缓冲区满了，生产者等待");
                    wait();
                }
                // 生产数据并放入缓冲区
                System.out.println("Produced: " + value);
                buffer.add(value++);
                // 唤醒消费者
                notifyAll();
            }
            Thread.sleep(1000); // 模拟生产耗时
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                // 如果缓冲区为空，消费者等待
                while (buffer.isEmpty()) {
                    System.out.println("如果缓冲区为空，消费者等待");
                    wait();
                }
                // 消费数据
                int value = buffer.poll();
                System.out.println("Consumed: " + value);
                // 唤醒生产者
                notifyAll();
            }
            Thread.sleep(1500); // 模拟消费耗时
        }
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();

        Thread producerThread = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}