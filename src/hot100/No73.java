package src.hot100;

import java.util.Arrays;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-10 18:45
 */
public class No73 {

    //https://leetcode.cn/problems/set-matrix-zeroes/solutions/670278/xiang-jie-fen-san-bu-de-o1-kong-jian-jie-dbxd/?envType=study-plan-v2&envId=top-100-liked


    public void setZeroes(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        boolean rowFlag=false,colFlag=false;
        //先标记第一行第一列是否有零
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0){
                colFlag=true;
                break;
            }
        }
        for(int i=0;i<n;i++){
            if(matrix[0][i]==0){
                rowFlag=true;
                break;
            }
        }
        //然后标记每个数是否为零，是的话把该行该列的第一个数记为0,并且再遍历一遍把对应的行和列置0

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        //然后遍历第一行第一列，为零把行和列都置为零
        for(int i=1;i<m;i++){
            if(matrix[i][0]==0){
                Arrays.fill(matrix[i],0);
            }
        }
        for(int i=0;i<n;i++){
            if(matrix[0][i]==0){
                for(int j=1;j<m;j++){
                    matrix[j][i]=0;
                }
            }
        }
        //看看行标记和列标记是否为零，是的话就把第一行第一列置为零
        if(rowFlag){
            for(int i=0;i<n;i++){
                matrix[0][i]=0;
            }
        }
        if(colFlag){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }
    }
//
//    public void setZeroes(int[][] matrix) {
//        boolean colFlag=false,rowFlag=false;
//        int row=matrix.length,col=matrix[0].length;
//        for(int i=0;i<row;i++){
//            if(matrix[i][0]==0){
//                colFlag=true;
//                break;
//            }
//        }
//        for(int i=0;i<col;i++){
//            if(matrix[0][i]==0){
//                rowFlag=true;
//                break;
//            }
//        }
//        for(int i=1;i<row;i++){
//            for(int j=1;j<col;j++){
//                if(matrix[i][j]==0){
//                    matrix[i][0]=0;
//                    matrix[0][j]=0;
//                }
//            }
//        }
//        for(int i=1;i<row;i++){
//            if(matrix[i][0]==0){
//                for(int j=0;j<col;j++){
//                    matrix[i][j]=0;
//                }
//            }
//        }
//        for(int i=1;i<col;i++){
//            if(matrix[0][i]==0){
//                for(int j=0;j<row;j++){
//                    matrix[j][i]=0;
//                }
//            }
//        }
//
//
//        if(colFlag){
//            for(int i=0;i<row;i++) {
//                matrix[i][0] = 0;
//            }
//        }
//
//
//        if(rowFlag){
//            for(int i=0;i<col;i++) {
//                matrix[0][i] = 0;
//            }
//        }
//
//
//
//    }
//    public void setZeroes(int[][] matrix) {
//        boolean colFlag=false,rowFlag=false;
//        int row=matrix.length,col=matrix[0].length;
//        for(int i=0;i<row;i++){
//            if(matrix[i][0]==0)colFlag=true;
//        }
//        for(int i=0;i<col;i++){
//            if(matrix[0][i]==0)rowFlag=true;
//        }
//        for(int i=1;i<row;i++){
//            for(int j=1;j<col;j++){
//                if(matrix[i][j]==0){
//                    matrix[i][0]=0;
//                    matrix[0][j]=0;
//                }
//            }
//        }
//        for(int i=1;i<row;i++){
//            if(matrix[i][0]==0) {
//                for(int j=1;j<col;j++){
//                    matrix[i][j]=0;
//                }
//            }
//        }
//        for(int i=1;i<col;i++){
//            if(matrix[0][i]==0) {
//                for(int j=1;j<row;j++){
//                    matrix[j][i]=0;
//                }
//            }
//        }
//        if(colFlag){
//            for(int i=0;i<row;i++){
//                matrix[i][0]=0;
//            }
//        }
//        if(rowFlag){
//            for(int i=0;i<col;i++){
//                matrix[0][i]=0;
//            }
//
//        }
//    }

    public static void main(String[] args) {
        //示例 1：
        //
        //
        //输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
        //输出：[[1,0,1],[0,0,0],[1,0,1]]
        //示例 2：
        //
        //
        //输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
        //输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        No73 no73 = new No73();
        no73.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        no73.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");

            }
        }
        System.out.println();
    }
}
