package src.didi;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        TreeMap<Long,Long> treeMap=new TreeMap<>();
        for(int l=0;l<t;l++){
            treeMap=new TreeMap<>();
            int n=in.nextInt();
            long m=in.nextLong();
            long[] nums=new long[n];
            for(int i=0;i<n;i++){
                nums[i]=in.nextInt();
                treeMap.put(nums[i],treeMap.getOrDefault(nums[i],0L)+1);
            }
            long res=0;
            System.out.println(res);
        }
    }


//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        int t=in.nextInt();
//        TreeMap<Long,Long> treeMap=new TreeMap<>();
//        for(int l=0;l<t;l++){
//            treeMap=new TreeMap<>();
//            int n=in.nextInt();
//            long m=in.nextLong();
//            long[] nums=new long[n];
//            for(int i=0;i<n;i++){
//                nums[i]=in.nextInt();
//                treeMap.put(nums[i],treeMap.getOrDefault(nums[i],0L)+1);
//            }
//            long res=0;
//            for(int i=0;i<m;i++){
//                if(treeMap.size()==1){
//                    break;
//                }else {
//                    long max=treeMap.lastKey();
//                    long maxCount=treeMap.get(max);
//                    long min=treeMap.firstKey();
//                    long minCount=treeMap.get(min);
//                    if (maxCount == 1) {
//                        treeMap.remove(max);
//                    } else {
//                        treeMap.put(max, treeMap.get(max) - 1);
//                    }
//                    treeMap.put(max - 1, treeMap.getOrDefault(max - 1, 0L) + 1);
//
//                    if (minCount == 1) {
//                        treeMap.remove(min);
//                    } else {
//                        treeMap.put(min, treeMap.get(min) - 1);
//                    }
//
//                    treeMap.put(min + 1, treeMap.getOrDefault(min + 1, 0L) + 1);
//                }
//            }
//            res=treeMap.lastKey()-treeMap.firstKey();
//            System.out.println(res);
//        }
//    }

//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        int n=in.nextInt();
//        int[][] nums=new int[n][2];
//        int sum=0;
//        for(int i=0;i<n;i++){
//            for(int j=0;j<2;j++){
//                nums[i][j]=in.nextInt();
//            }
//            sum+=Math.abs(nums[i][0]);
//        }
//        int[] dp=new int[2*sum+1];
//        int max=Integer.MAX_VALUE/2;
//        for(int i=0;i<=2*sum;i++){
//            dp[i]=max;
//        }
//        dp[sum]=0;
//        for(int i=0;i<n;i++){
//            for(int j=2*sum;j>=0;j--){
//                if(dp[j]==max)continue;
//                int newj=j+nums[i][0];
//                if(newj<0||newj>2*sum)continue;
//                dp[newj]=Math.min(dp[newj],dp[j]+nums[i][1]);
//            }
//        }
//        if(dp[sum+1]==max) System.out.println(-1);
//        else System.out.println(dp[sum+1]);
//
//
//    }

//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        int n=in.nextInt();
//        int[][] nums=new int[n][2];
//        int sum=0;
//        for(int i=0;i<n;i++){
//            for(int j=0;j<2;j++){
//                nums[i][j]=in.nextInt();
//            }
//            sum+=Math.abs(nums[i][0]);
//        }
//        int[][] dp=new int[n+1][sum];
//        for(int i=0;i<n;i++){
//            for(int j=sum;j>0;j--){
//
//
//            }
//        }
//
//
//
//    }

}
