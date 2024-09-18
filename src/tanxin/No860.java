package src.tanxin;

/**
 * @author: Yuan Yuqing
 * @date: 2024-05-18 21:43
 */
public class No860 {

    public boolean lemonadeChange(int[] bills) {

        int[] count=new int[3];
        for(int i=0;i<bills.length;i++){
            int num=bills[i];
            if(num==5){
                count[0]++;
            } else if (num==10) {
                count[0]--;
                count[1]++;
                if(count[0]<0)return false;

            }else {
                count[2]++;
                if(count[1]>=1){
                    count[1]--;
                    count[0]--;
                    if(count[0]<0)return false;
                }
                else {
                    count[0]=count[0]-3;
                    if(count[0]<0)return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：bills = [5,5,5,10,20]
        //输出：true
        //解释：
        //前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
        //第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
        //第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
        //由于所有客户都得到了正确的找零，所以我们输出 true。
        //示例 2：
        //
        //输入：bills = [5,5,10,10,20]
        //输出：false
        //解释：
        //前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
        //对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
        //对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
        //由于不是每位顾客都得到了正确的找零，所以答案是 false。

        int[] bills = {5,5,5,10,20};
        No860 no860 = new No860();
        System.out.println(no860.lemonadeChange(bills));
        bills = new int[]{5,5,10,10,20};
        System.out.println(no860.lemonadeChange(bills));

    }
}
