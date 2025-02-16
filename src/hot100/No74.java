package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-02-13 15:17
 */
public class No74 {

    //哈哈靠自己做出来了！！！
    //https://leetcode.cn/problems/search-a-2d-matrix/solutions/2783931/liang-chong-fang-fa-er-fen-cha-zhao-pai-39d74/?envType=study-plan-v2&envId=top-100-liked
    //这个做法更加合适


    public boolean searchMatrix(int[][] matrix, int target) {
        int m =matrix.length,n = matrix[0].length;
        int left=0,right=m*n-1;
        while (left<=right){
            int mid = (left+right)/2;
            int num=matrix[mid/n][mid%n];
            if(num==target)return true;
            else if (num>target) {
                right=mid-1;
            }
            else left=mid+1;
        }

        return false;

    }

//    public boolean searchMatrix(int[][] matrix, int target) {
//        int m =matrix.length,n = matrix[0].length;
//        int i=0,j=0;
//        while (i<m&&j<n){
//            if(matrix[i][j]==target)return true;
//            else if (matrix[i][j]>target) {
//                return false;
//            }else {
//                while (j+1<n&&matrix[i][j]<target){
//                    j++;
//                }
//                if(matrix[i][j]>target)return false;
//                if(matrix[i][j]==target)return true;
//            }
//            i++;
//            j=0;
//
//        }
//        return false;
//
//    }

    public static void main(String[] args) {
        //示例 1：
        //
        //
        //输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
        //输出：true
        //示例 2：
        //
        //
        //输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
        //输出：false

        //[[1,3,5,7],[10,11,16,20],[23,30,34,50]]

        //输出：false
        No74 no74 = new No74();
        int[][] matrix = new int[][]{
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,50}
        };
        System.out.println(no74.searchMatrix(matrix, 10));
//        No74 no74 = new No74();
//        int[][] matrix = new int[][]{
//                {1,3,5,7},
//                {10,11,16,20},
//                {23,30,34,60}
//        };
//        System.out.println(no74.searchMatrix(matrix, 3));
//        System.out.println(no74.searchMatrix(matrix, 13));
    }
}
