package src.tyy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Yuan Yuqing
 * @date: 2025-09-15 20:15
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            long n = in.nextLong();
            if(n%3!=1) System.out.println(0);
            else System.out.println(1);


        }
    }

}
//public class Main {
//    public static int[] res=new int[1000000000];
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t=in.nextInt();
//        // 注意 hasNext 和 hasNextLine 的区别
//        Arrays.fill(res,-1);
//        res[1]=1;
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            long n = in.nextLong();
//            int ans=0;
//            for(int i=1;i<=n;i++){
//                ans+=fun(i);
//                ans=ans%2;
//            }
//            System.out.println(ans%2);
//
//
//        }
//    }
//    public static int fun(int n){
//        if(res[n]!=-1)return res[n];
//        int sum=n;
//        for(int i=n/2;i>=1;i--){
//            if(n%i==0){
//                sum+=res[i];
//                break;
//            }
//        }
//        if((sum&2)==0)res[n]=0;
//        else res[n]=1;
//        return sum%2==0?0:1;
//
//    }
//}
//public class Main {
//    public static int[] res=new int[10000000];
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t=in.nextInt();
//        // 注意 hasNext 和 hasNextLine 的区别
//        res[1]=1;
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            int n = in.nextInt();
//            int ans=0;
//            for(int i=1;i<=n;i++){
//                ans+=fun(i);
//            }
//            System.out.println(ans%2);
//
//
//        }
//    }
//    public static int fun(int n){
//        if(res[n]!=0)return res[n];
//        int sum=n;
//        for(int i=n/2;i>=1;i--){
//            if(n%i==0){
//                sum+=res[i];
//                break;
//            }
//        }
//        if((sum&2)==0)res[n]=2;
//        else res[n]=1;
//        return sum%2==0?2:1;
//
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t=in.nextInt();
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            int n = in.nextInt();
//            int[] nums=new int[n];
//            for(int i=0;i<n;i++){
//                nums[i]=in.nextInt();
//            }
//            int flag=1;
//            for(int i=0;i<n;i++){
//                int res=nums[0]^(i+1)^1;
//                if(res!=nums[i]){
//                    flag=0;
//                    break;
//                }
//
//            }
//            if(flag==0) System.out.println("No");
//            else System.out.println("Yes");
//        }
//    }
//}

//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t=in.nextInt();
//        // 注意 hasNext 和 hasNextLine 的区别
//        for(int l=0;l<t;l++){
//            int n=in.nextInt();
//            int m=in.nextInt();
//            if(m==1&&n!=1){
//                System.out.println(n/2);
//                for(int i=1;i<=n/2;i++){
//                    System.out.print(i+" ");
//                }
//            }else if(n==1){
//                System.out.println(0);
//                System.out.println();
//
//            }else{
//                System.out.println(n-1);
//                for(int i=1;i<=n-1;i++){
//                    System.out.print(i+" ");
//                }
//
//            }
//        }
//    }
//}