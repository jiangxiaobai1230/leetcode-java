package src.hot100;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-14 16:58
 */

//https://leetcode.cn/problems/find-median-from-data-stream/solutions/3015873/ru-he-zi-ran-yin-ru-da-xiao-dui-jian-ji-4v22k/?envType=study-plan-v2&envId=top-100-liked

public class MedianFinder {
    private final PriorityQueue<Integer> left=new PriorityQueue<>((a,b)->b-a);
    private final PriorityQueue<Integer> right=new PriorityQueue<>();
    public MedianFinder() {

    }

    public void addNum(int num) {
        if(left.size()==right.size()){
            right.offer(num);
            left.offer(right.poll());
        }else {
            left.offer(num);
            right.offer(left.poll());
        }

    }

    public double findMedian() {
        if(left.size()>right.size())return left.peek();
        return (left.peek()+right.peek())/2.0;
    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入
        //["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
        //[[], [1], [2], [], [3], []]
        //输出
        //[null, null, null, 1.5, null, 2.0]
        //
        //解释
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        medianFinder.findMedian(); // return 2.0

    }
}