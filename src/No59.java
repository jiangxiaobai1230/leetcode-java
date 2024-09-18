package src;

/**
*
*
* @author: Yuan Yuqing
* @date: 2024-03-12 15:31
* 
*/
public class No59 {

        public int[][] generateMatrix(int n) {

            int start = 0;
            int loopCount = 1;
            int num = 0;
            int [][] arr = new int[n][n];
            while(loopCount <= n/2){
                for(int i=start;i<n-start-1;i++){
                    arr[start][i]=++num;
                }
                for(int i=start;i<n-start-1;i++){
                    arr[i][n-start-1]=++num;
                }
                for(int i=n-start-1;i>start;i--){
                    arr[n-start-1][i]=++num;
                }
                for(int i=n-start-1;i>start;i--){
                    arr[i][start]=++num;
                }
                start++;
                loopCount++;

            }
            if(n%2!=0){
                arr[start][start]=++num;
            }


            return arr;
        }
        public static void main(String[] args) {
            No59 no59 = new No59();
            int[][] arr = no59.generateMatrix(4);
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
}
