package src.xhs;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * @author: Yuan Yuqing
 * @date: 2025-08-31 19:22
 */
public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n=0,x=0,y=0;
//        while (in.hasNext()){
//            int t=in.nextInt();
//            for(int m=0;m<t;m++){
//                n=in.nextInt();
//                x=in.nextInt();
//                y=in.nextInt();
//                for(int i=0;i<n-1;i++){
//                    String s=in.next();
//                }
//                int sum=0;
//                for(int i=0;i<n;i++){
//                    Random random=new Random();
//                    int s=random.nextInt(1);
//                    int s2=random.nextInt();
//                    if(s2==0){
//                        sum+=s*x;
//                    }else sum+=s*y;
//                }
//                System.out.println(sum);
//            }
//            in.close();
//
//        }
//
//
//
//    }
//
//
//}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0, a = 0, b = 0, c = 0;
        int t = 0;
        while (in.hasNext()) {
            t = in.nextInt();
            for (int m = 0; m < t; m++) {
                n = in.nextInt();
                a = in.nextInt();
                b = in.nextInt();
                c = in.nextInt();
                Set<Integer> set=new HashSet<>();
                set.add(a);
                set.add(b);
                set.add(c);
                int len=set.size();

                long[] dp = new long[n + 1];
                long[] dpa = new long[n + 1];
                long[] dpbc = new long[n + 1];
                dp[0] = 1;
                for (int k = 1; k <= n; k++) {
                    dpa[k]=0;
                    dpbc[k]=0;
                    long pre=0;
                    for(int l:set){
                        if(k<l) {
                            continue;
                        }
                        pre=0;
                        if(l==c){
                            pre=(dp[k-l]-dpa[k-l])%1000000007;

                        }else {
                            pre=dp[k-l];
                        }
                        if(l==a){
                            dpa[k]=(dpbc[k]+pre)%1000000007;
                        }else {
                            dpbc[k]=(dpbc[k]+pre)%1000000007;
                        }
                    }

                    dp[k] = (dpa[k] + dpbc[k] )%1000000007;

                }
                for (int j = 1; j <= n; j++) {
                    System.out.print(dp[j] + " ");
                }
                System.out.println();


            }

        }

    }
}

//    public static void main(String[] args) {
//        Scanner in=new Scanner(System.in);
//        int n=in.nextInt();
//        in.hasNextLine();
//        String s=in.next();
//        int[] res=new int[n];
//        int[] count=new int[128];
//        int pre=0;
//        for(int i=1;i<=s.length();i++){
//            count[s.charAt(i-1)]++;
//            int c=count[s.charAt(i-1)];
//            res[i-1]=i*(i+1)/2-pre-c;
//            pre+=c;
//        }
//
//        for(int i=0;i<n;i++){
//            System.out.println(res[i]);
//        }
//
//    }


