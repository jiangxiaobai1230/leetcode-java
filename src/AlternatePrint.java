package src;

/**
 * @author: Yuan Yuqing
 * @date: 2025-08-27 15:55
 */
public class AlternatePrint {
    // 共享计数器，从1开始
    private int count = 1;
    // 打印的最大数值
    private final int max;

    public AlternatePrint(int max) {
        this.max = max;
    }

    // 打印奇数的方法
    public synchronized void printOdd() {
        while (count <= max) {
            // 若当前是奇数，打印并更新计数器
            if (count % 2 == 1) {
                System.out.println(Thread.currentThread().getName() + ": " + count);
                count++;
                // 通知偶数线程执行
                notify();
            } else {
                try {
                    // 若当前是偶数，奇数线程等待
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
        // 循环结束后通知对方线程（避免对方无限等待）
        notify();
    }

    // 打印偶数的方法
    public synchronized void printEven() {
        while (count <= max) {
            // 若当前是偶数，打印并更新计数器
            if (count % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + count);
                count++;
                // 通知奇数线程执行
                notify();
            } else {
                try {
                    // 若当前是奇数，偶数线程等待
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
        // 循环结束后通知对方线程
        notify();
    }

    public static void main(String[] args) {
        // 打印1到10的奇偶数
        AlternatePrint printer = new AlternatePrint(10);

        // 奇数线程
        Thread oddThread = new Thread(printer::printOdd, "奇数线程");
        // 偶数线程
        Thread evenThread = new Thread(printer::printEven, "偶数线程");

        // 启动线程
        oddThread.start();
        evenThread.start();
    }
}
