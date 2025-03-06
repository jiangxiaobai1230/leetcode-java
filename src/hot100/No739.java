package src.hot100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-05 12:18
 */
public class No739 {
    //https://leetcode.cn/problems/daily-temperatures/solutions/11967/jie-ti-si-lu-by-pulsaryu/?envType=study-plan-v2&envId=top-100-liked


    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> deque=new LinkedList<>();
        int n=temperatures.length;
        int[] res=new int[n];
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j+=res[j]){
                if(temperatures[j]>temperatures[i]){
                    res[i]=j-i;
                    break;
                }else {
                    if(res[j]==0){
                        res[i]=0;
                        break;
                    }
                }
            }
        }
        return res;

    }

//    public int[] dailyTemperatures(int[] temperatures) {
//        Deque<Integer> deque=new LinkedList<>();
//        int n=temperatures.length;
//        int[] res=new int[n];
//        for(int i=n-1;i>=0;i--){
//            int num=temperatures[i];
//            while (!deque.isEmpty()&&temperatures[deque.peek()]<=num){
//                deque.pop();
//            }
//            if(!deque.isEmpty()){
//                res[i]=deque.peek()-i;
//            }
//            deque.push(i);
//        }
//        return res;
//
//    }

    public static void main(String[] args) {
        //示例 1:
        //
        //输入: temperatures = [73,74,75,71,69,72,76,73]
        //输出: [1,1,4,2,1,1,0,0]
        //示例 2:
        //
        //输入: temperatures = [30,40,50,60]
        //输出: [1,1,1,0]
        //示例 3:
        //
        //输入: temperatures = [30,60,90]
        //输出: [1,1,0]

        int[] res1 = new No739().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int i : res1) {
            System.out.println(i);
        }
        res1 = new No739().dailyTemperatures(new int[]{30, 40, 50, 60});
        for (int i : res1) {
            System.out.println(i);
        }
        res1 = new No739().dailyTemperatures(new int[]{30, 60, 90});
        for (int i : res1) {
            System.out.println(i);
        }

    }
}
