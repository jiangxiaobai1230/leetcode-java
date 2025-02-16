package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-21 23:05
 */
public class No200 {
    //https://leetcode.cn/problems/number-of-islands/solutions/16884/number-of-islands-shen-du-you-xian-bian-li-dfs-or-/?envType=study-plan-v2&envId=top-100-liked
    //第一反应dfs
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }

            }
        }
        return count;

    }
    void dfs(char[][] grid,int i,int j){
        if(!isArea(grid,i,j))return;
        if(grid[i][j]!='0') {
            grid[i][j] = '0';
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }


    }
    boolean isArea(char[][] grid,int i,int j){
        return i>=0&&i<grid.length&&j>=0&&j<grid[0].length;

    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：grid = [
        //  ["1","1","1","1","0"],
        //  ["1","1","0","1","0"],
        //  ["1","1","0","0","0"],
        //  ["0","0","0","0","0"]
        //]
        //输出：1
        //示例 2：
        //
        //输入：grid = [
        //  ["1","1","0","0","0"],
        //  ["1","1","0","0","0"],
        //  ["0","0","1","0","0"],
        //  ["0","0","0","1","1"]
        //]
        //输出：3
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        No200 no200 = new No200();
        System.out.println(no200.numIslands(grid));
        grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(no200.numIslands(grid));
    }
}
