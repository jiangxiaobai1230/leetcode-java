package src.hash;

/**
 * @author: Yuan Yuqing
 * @date: 2024-03-20 10:11
 */
public class No202 {

    public int getSum(int n){

        int sum=0;
        while(n>0){
            int t=n%10;
            sum+=t*t;
            n=n/10;
        }
        return sum;
    }


    public boolean isHappy(int n) {
        int low=n,fast=getSum(n);
        while(fast!=1 && fast!=low){
            low=getSum(low);
            fast=getSum(getSum(fast));
        }
        return fast==1;
    }
    public static void main(String[] args) {

        //输入：n = 19
        //输出：true
        //解释：
        //12 + 92 = 82
        //82 + 22 = 68
        //62 + 82 = 100
        //12 + 02 + 02 = 1
        //示例 2：
        //
        //输入：n = 2
        //输出：false
        No202 no202 = new No202();
        System.out.println(no202.isHappy(19));
        System.out.println(no202.isHappy(7));

    }
}
