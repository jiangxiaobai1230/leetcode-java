package src.xiecheng;

import java.util.Scanner;

/**
 * @author: Yuan Yuqing
 * @date: 2025-09-04 19:01
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int k=in.nextInt();
        int[] r=new int[m];
        int[] res=new int[n];
        int[][] edge=new int[n-1][3];
        for(int i=0;i<m;i++){
            r[i]=in.nextInt();
        }
        for(int i=0;i<n-1;i++){
            for(int j=0;j<3;j++){
                edge[i][j]=in.nextInt();
            }
        }
        System.out.println();

    }


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n=in.nextInt();
//        int l=0,r=0,k=0,x=0;
//        for(int i=0;i<n;i++){
//            l=in.nextInt();
//            r=in.nextInt();
//            k=in.nextInt();
//            x=in.nextInt();
//            int start = (l - x+k-1) / k;
//            int first=start*k+x;
//            if(first>r) {
//                System.out.println(0);
//                continue;
//            }
//            int end=(r-x)/k;
//            int last=end*k+x;
//            if(last<l) {
//                System.out.println(0);
//                continue;
//            }
//            System.out.println(end-start+1);
//
//        }
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n=in.nextInt();
//        int[] nums=new int[n];
//        for(int i=0;i<n;i++){
//            nums[i]=in.nextInt();
//        }
//        int max=0;
//        for(int i=0;i<n;i++){
//            int num=nums[i];
//            if(max<num)max=num;
//            System.out.print(max-i-1+" ");
//        }
//        System.out.println();
//    }
//    public static String[] store=new String[401];
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int t=0;
//        char[] types={'G','D','C'};
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            t = in.nextInt();
//            for(int j=0;j<t;j++){
//                int v=in.nextInt();
//                if(store[v]!=null){
//                    System.out.println(store[v]);
//                    continue;
//                }
//                String r=fun(v);
//                store[v]=r;
//                System.out.println(r);
//            }
//
//
//        }
//    }
//    static String fun(int v){
//        if(v<160||v>350)return "other";
//        StringBuffer s=new StringBuffer();
//        if(v>=250&&v<=350)s.append("G");
//        if(v>=160&&v<=250){
//            if(s.length()!=0){
//                s.append(" ");
//            }
//            s.append("D");
//        }
//        if(v>=200&&v<=300){
//            if(s.length()!=0){
//                s.append(" ");
//            }
//            s.append("C");
//        }
//        if(s.equals(""))s.append("other");
//        return s.toString();
//
//    }
}
