package src.tanxin;

import java.util.Arrays;

/**
 * @author: Yuan Yuqing
 * @date: 2024-05-22 21:50
 */
public class No452 {

    public int findMinArrowShots(int[][] points) {

        int count=1;

        Arrays.sort(points, (a, b) -> Integer.compare(a[1],b[1]));
        int right=points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0]<=right){
                continue;
            }else {
                count++;
                right=points[i][1];
            }

        }


        return count;

    }

    public static void main(String[] args) {

        //
        //示例 1：
        //
        //输入：points = [[10,16],[2,8],[1,6],[7,12]]
        //输出：2
        //解释：气球可以用2支箭来爆破:
        //-在x = 6处射出箭，击破气球[2,8]和[1,6]。
        //-在x = 11处发射箭，击破气球[10,16]和[7,12]。
        //示例 2：
        //
        //输入：points = [[1,2],[3,4],[5,6],[7,8]]
        //输出：4
        //解释：每个气球需要射出一支箭，总共需要4支箭。
        //示例 3：
        //
        //输入：points = [[1,2],[2,3],[3,4],[4,5]]
        //输出：2
        //解释：气球可以用2支箭来爆破:
        //- 在x = 2处发射箭，击破气球[1,2]和[2,3]。
        //- 在x = 4处射出箭，击破气球[3,4]和[4,5]。
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        No452 no452 = new No452();
        System.out.println(no452.findMinArrowShots(points));
        System.out.println(no452.findMinArrowShots(new int[][]{{1,2},{3,4},{5,6},{7,8}}));
        System.out.println(no452.findMinArrowShots(new int[][]{{1,2},{2,3},{3,4},{4,5}}));
        //[[-2147483646,-2147483645],[2147483646,2147483647]]

        System.out.println(no452.findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}}));
        //[[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]
        System.out.println(no452.findMinArrowShots(new int[][]{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}}));



    }

}
