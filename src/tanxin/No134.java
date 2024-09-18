package src.tanxin;

/**
 * @author: Yuan Yuqing
 * @date: 2024-05-16 22:05
 */
public class No134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {

     int n=gas.length;
     int curSum=0,totalSum=0,index=0;
     for(int i=0;i<n;i++){
         curSum+=gas[i]-cost[i];
         totalSum+=gas[i]-cost[i];
         if(curSum<0){
             index=i+1;
             curSum=0;
         }
     }
     if(totalSum<0)return -1;
     return index;

    }

//    public int canCompleteCircuit(int[] gas, int[] cost) {
//
//        int index=-1;
//        int n=gas.length;
//        int remain;
//        int flag=0;
//        for(int i=0;i<n;i++){
//            if(gas[i]>=cost[i]){
//                remain=0;
//                for(int j=0;j<n;j++) {
//                    remain += gas[(i+j)%n];
//                    remain -= cost[(i+j)%n];
//                    if(remain<=0&&j!=n-1) {
//                        flag=1;
//                        break;
//                    }
//                    if(j==n-1&&remain>=0)index=i;
//                }
//            }
//        }
//        return index;
//
//    }

    public static void main(String[] args) {

        //示例 1:
        //
        //输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
        //输出: 3
        //解释:
        //从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
        //开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
        //开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
        //开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
        //开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
        //开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
        //因此，3 可为起始索引。
        //示例 2:
        //
        //输入: gas = [2,3,4], cost = [3,4,3]
        //输出: -1
        //解释:
        //你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
        //我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
        //开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
        //开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
        //你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
        //因此，无论怎样，你都不可能绕环路行驶一周。

        int[] gas=new int[]{1,2,3,4,5};
        int[] cost=new int[]{3,4,5,1,2};
        No134 no134=new No134();
        System.out.println(no134.canCompleteCircuit(gas,cost));

        int[] gas1=new int[]{2,3,4};
        int[] cost1=new int[]{3,4,3};
        System.out.println(no134.canCompleteCircuit(gas1,cost1));

        int[] gas2=new int[]{5,1,2,3,4};
        int[] cost2=new int[]{4,4,1,5,1};
        System.out.println(no134.canCompleteCircuit(gas2,cost2));

    }
}
