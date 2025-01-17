package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-10 21:31
 */
public class No48 {

    //https://leetcode.cn/problems/rotate-image/solutions/1228078/48-xuan-zhuan-tu-xiang-fu-zhu-ju-zhen-yu-jobi/?envType=study-plan-v2&envId=top-100-liked

    //自己做出来的！！！！
    public void rotate(int[][] matrix) {
        int m=matrix.length-1,n=matrix[0].length-1;
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n-i-1;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-j][m-i];
                matrix[n-j][m-i]=temp;
            }
        }

        for(int i=0;i<=m/2;i++){
            for(int j=0;j<=n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[m-i][j];
                matrix[m-i][j]=temp;
            }
        }

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //
        //输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        //输出：[[7,4,1],[8,5,2],[9,6,3]]
        //示例 2：
        //
        //
        //输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
        //输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
        int[][] matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        No48 no48 = new No48();
        no48.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        no48.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }
}
