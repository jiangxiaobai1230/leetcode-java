package src.danDiaoStack;

/**
 * @author: Yuan Yuqing
 * @date: 2024-09-26 20:10
 */
public class No739 {
    public int[] dailyTemperatures(int[] temperatures) {

    }

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

        int[] temperatures = {73,74,75,71,69,72,76,73};
        No739 no739 = new No739();
        int[] result = no739.dailyTemperatures(temperatures);
        for (int i : result) {
            System.out.println(i);
        }
        System.out.println();
        temperatures = new int[]{30,40,50,60};
        result = no739.dailyTemperatures(temperatures);
        for (int i : result) {
            System.out.println(i);
        }
        System.out.println();
        temperatures = new int[]{30,60,90};
        result = no739.dailyTemperatures(temperatures);
        for (int i : result) {
            System.out.println(i);
        }
        System.out.println();

    }
}
