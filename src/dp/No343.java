package src.dp;

/**
 * @author: Yuan Yuqing
 * @date: 2024-06-01 23:34
 */
public class No343 {


    ///* 数学题，当因子为3时，整数拆分乘积最大，因子次优为2，最差为1 */

    public int integerBreak(int n) {
        if(n <= 3) return n - 1;
        int a=n/3,b=n%3;
        if(b==0){
            return (int) (Math.pow(3,a));
        }else if(b==1){
            return (int) (Math.pow(3,a-1)*4);
        }else return (int) (Math.pow(3,a))*2;

    }

    public static void main(String[] args) {
        //示例 1:
        //
        //输入: n = 2
        //输出: 1
        //解释: 2 = 1 + 1, 1 × 1 = 1。
        //示例 2:
        //
        //输入: n = 10
        //输出: 36
        //解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。

        No343 no343 = new No343();
//        System.out.println(no343.integerBreak(2));
        System.out.println(no343.integerBreak(11));


    }

}
