package src.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-10 19:16
 */
public class No54 {
    //https://leetcode.cn/problems/spiral-matrix/?envType=study-plan-v2&envId=top-100-liked
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length==0)return new ArrayList<>();
        int m=matrix.length,n=matrix[0].length;
        List<Integer> res=new LinkedList<>();
        int left=0,right=n-1,top=0,bottom=m-1;
        while (true){
            for(int i=left;i<=right;i++){
                res.add(matrix[top][i]);
            }
            top++;
            if(top>bottom)break;
            for(int i=top;i<=bottom;i++){
                res.add(matrix[i][right]);
            }
            right--;
            if(left>right)break;
            for(int i=right;i>=left;i--){
                res.add(matrix[bottom][i]);
            }
            bottom--;
            if(top>bottom)break;
            for(int i=bottom;i>=top;i--){
                res.add(matrix[i][left]);
            }
            left++;
            if(left>right)break;

        }


        return res;

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //
        //输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        //输出：[1,2,3,6,9,8,7,4,5]
        //示例 2：
        //
        //
        //输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        //输出：[1,2,3,4,8,12,11,10,9,5,6,7]
        No54 no54=new No54();
        List<Integer> list = no54.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println();


        List<Integer> list1 = no54.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        for (Integer integer : list1) {
            System.out.println(integer);
        }

    }
}
