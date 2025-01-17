package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-11 23:18
 */
public class No240 {

    //https://leetcode.cn/problems/search-a-2d-matrix-ii/solutions/2361487/240-sou-suo-er-wei-ju-zhen-iitan-xin-qin-7mtf/?envType=study-plan-v2&envId=top-100-liked
    //我想到的是左上角和右下角，稍微麻烦点，但其实也能做

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length,n = matrix[0].length;
        int i=m-1,j=0;
        while (i>=0&&j<n){
            if(matrix[i][j]>target){
                i--;
            }
            else if(matrix[i][j]<target){
                j++;
            }
            else return true;
        }
        return false;


    }

    public static void main(String[] args) {
        //示例 1：
        //
        //
        //输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
        //输出：true
        //示例 2：
        //
        //
        //输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
        //输出：false
        No240 no240 = new No240();
        int[][] matrix = new int[][]{
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
        System.out.println(no240.searchMatrix(matrix, 5));
        System.out.println(no240.searchMatrix(matrix, 20));

    }
}
