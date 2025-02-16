package src.hot100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-21 23:33
 */

//https://leetcode.cn/problems/rotting-oranges/solutions/129831/li-qing-si-lu-wei-shi-yao-yong-bfsyi-ji-ru-he-xie-/comments/2126691
public class No994 {
    int freshOrangeCount=0;
    Queue<int[]> queue=new LinkedList<>();
    public int orangesRotting(int[][] grid) {
        int m=grid.length,n=grid[0].length;

        int min=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)freshOrangeCount++;
                else if (grid[i][j]==2) {
                    queue.add(new int[]{i,j});
                }
            }
        }
        while (freshOrangeCount!=0&&!queue.isEmpty()){
            min++;
            int num=queue.size();
            for(int k=0;k<num;k++) {
                int i = queue.peek()[0];
                int j = queue.peek()[1];
                queue.poll();
                dfs(grid, i - 1, j);
                dfs(grid, i + 1, j);
                dfs(grid, i, j - 1);
                dfs(grid, i, j + 1);
            }
        }
        return freshOrangeCount>0?-1:min;

    }
    void dfs(int[][] grid,int i,int j){
        if(!isArea(grid,i,j)){
            return;
        }
        if(grid[i][j]!=1)return;
        grid[i][j]=2;
        freshOrangeCount--;
        queue.add(new int[]{i,j});


    }
    boolean isArea(int[][] grid,int i,int j){
        return i>=0&&i<grid.length&&j>=0&&j<grid[0].length;

    }

    public static void main(String[] args) {
        //输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
        //输出：4
        //示例 2：
        //
        //输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
        //输出：-1
        //解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
        //示例 3：
        //
        //输入：grid = [[0,2]]
        //输出：0
        //解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
        int[][] grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        No994 no994 = new No994();
        System.out.println(no994.orangesRotting(grid));

        grid = new int[][]{{2,1,1},{0,1,1},{1,0,1}};
        no994 = new No994();
        System.out.println(no994.orangesRotting(grid));

        grid = new int[][]{{0,2}};
        no994 = new No994();
        System.out.println(no994.orangesRotting(grid));
    }
}
