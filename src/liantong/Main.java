package src.liantong;

import java.util.Scanner;


import java.util.Scanner;

//public class Main {
//    static String[] queue = new String[1005];
//    static int front = 0, rear = 0;
//
//    static void add(String num) {
//        // TODO: 将新号码加入队尾
//        queue[rear++]=num;
//    }
//
//    static boolean isEmpty() {
//        // TODO: 判断队列是否为空
//        if(rear==front)return true;
//        return false;
//    }
//
//    static void next() {
//        // TODO: 如果队列为空，输出 EMPTY，否则输出并出队
//        if(isEmpty()) System.out.println("EMPTY");
//        else {
//            System.out.println(queue[front++]);
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            String cmd = sc.next();
//            if (cmd.equals("ADD")) {
//                String num = sc.next();
//                add(num);
//            } else if (cmd.equals("NEXT")) {
//                next();
//            } else if (cmd.equals("EXIT")) {
//                break;
//            }
//        }
//        sc.close();
//    }
//}


public class Main {
    public static String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        String[] words = new String[n];
        int wordCount = 0;

        int i = 0;
        StringBuilder t = new StringBuilder();
        String tt=arr.toString().trim();
        String[] res=tt.split(" ");
        wordCount=res.length;
        while (i < n) {
            // TODO: 跳过空格
            while(i<n&&arr[i]==' '){
                i++;
            }
            // TODO: 提取一个单词
            while(i<n&&arr[i]!=' '){
                t.append(arr[i]);
                i++;
                if(i==n-1||arr[i]==' '){
                    if(i==n-1&&arr[i]!=' '){
                        t.append(arr[i]);
                    }
                    words[wordCount++]=t.toString();
                    t=new StringBuilder();
                }
            }

            // TODO: 保存单词到 words 数组
        }

        StringBuilder result = new StringBuilder();
        // TODO: 从 words[wordCount-1] 到 words[0] 反向拼接到 result
        for(int j=wordCount-1;j>=0;j--){
            result.append(res[j]);
            if(j!=0) {
                result.append(" ");
            }

        }
        return result.toString();
    }

//    public static String reverseWords(String s) {
//        char[] arr = s.toCharArray();
//        int n = arr.length;
//        String[] words = new String[n];
//        int wordCount = 0;
//
//        int i = 0;
//        StringBuilder t = new StringBuilder();
//        while (i < n) {
//            // TODO: 跳过空格
//            while(i<n&&arr[i]==' '){
//                i++;
//            }
//            // TODO: 提取一个单词
//            while(i<n&&arr[i]!=' '){
//                t.append(arr[i]);
//                i++;
//                if(i==n-1||arr[i]==' '){
//                    if(i==n-1&&arr[i]!=' '){
//                        t.append(arr[i]);
//                    }
//                    words[wordCount++]=t.toString();
//                    t=new StringBuilder();
//                }
//            }
//
//            // TODO: 保存单词到 words 数组
//        }
//
//        StringBuilder result = new StringBuilder();
//        // TODO: 从 words[wordCount-1] 到 words[0] 反向拼接到 result
//        for(int j=wordCount-1;j>=0;j--){
//            result.append(words[j]);
//            if(j!=0) {
//                result.append(" ");
//            }
//
//        }
//        return result.toString();
//    }


//    public static String reverseWords(String s) {
//        char[] arr = s.toCharArray();
//        int n = arr.length;
//        String[] words = new String[n];
//        int wordCount = 0;
//
//        int i = 0;
//        String t="";
//        while (i < n) {
//            // TODO: 跳过空格
//            while(i<n&&(arr[i]==' '||(arr[i]>='0'&&arr[i]<='9'))){
//                i++;
//            }
//            // TODO: 提取一个单词
//            while(i<n&&arr[i]!=' '&&!(arr[i]>='0'&&arr[i]<='9')){
//                t+=arr[i];
//                i++;
//                if(i==n-1||(arr[i]==' '||(arr[i]>='0'&&arr[i]<='9'))){
//                    if(i==n-1&&arr[i]!=' '&&!(arr[i]>='0'&&arr[i]<='9')){
//                        t+=arr[i];
//                    }
//                    words[wordCount++]=t;
//                    t="";
//                }
//            }
//
//            // TODO: 保存单词到 words 数组
//        }
//
//        StringBuilder result = new StringBuilder();
//        // TODO: 从 words[wordCount-1] 到 words[0] 反向拼接到 result
//        for(int j=wordCount-1;j>=0;j--){
//            result.append(words[j]);
//            if(j!=0) {
//                result.append(" ");
//            }
//
//        }
//        return result.toString();
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(reverseWords(s));
        sc.close();
    }
}


///**
// * @author: Yuan Yuqing
// * @date: 2025-09-14 18:20
// */
//import java.util.*;
//
//public class Main {
//    public static List<String> mergeUniqueContacts(String[] list1, String[] list2) {
//        ArrayList<String> merged = new ArrayList<>();
//        // 补充代码，实现双指针合并有序联系人，并保持去重
//        int i=0,j=0,len1=list1.length,len2=list2.length;
//        while (i<len1&&j<len2){
//            String name1=list1[i],name2=list2[j];
//            int res=name1.compareTo(name2);
//            if(res<0){
//                merged.add(name1);
//                i++;
//            } else if (res>0) {
//                merged.add(name2);
//                j++;
//
//            }else{
//                merged.add(name1);
//                i++;
//                j++;
//            }
//
//        }
//        while (i<len1){
//            merged.add(list1[i]);
//            i++;
//        }
//        while (j<len2){
//            merged.add(list2[j]);
//            j++;
//        }
//        return merged;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(), m = sc.nextInt();
//        String[] list1 = new String[n];
//        String[] list2 = new String[m];
//
//        for (int i = 0; i < n; i++) list1[i] = sc.next();
//        for (int i = 0; i < m; i++) list2[i] = sc.next();
//
//        List<String> merged = mergeUniqueContacts(list1, list2);
//
//        for (int i = 0; i < merged.size(); i++) {
//            System.out.print(merged.get(i));
//            if (i < merged.size() - 1) System.out.print(" ");
//        }
//    }
//}
