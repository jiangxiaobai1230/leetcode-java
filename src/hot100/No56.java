package src.hot100;

import src.tyy.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2025-10-28 22:39
 */
public class No56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> res=new ArrayList<>();
        int begin=intervals[0][0],end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(end>=intervals[i][1]){
                continue;
            }else if(end>=intervals[i][0]){
                end=Math.max(end,intervals[i][1]);
            }else {
                res.add(new int[]{begin,end});
                begin=intervals[i][0];
                end=intervals[i][1];
            }

        }
        res.add(new int[]{begin,end});
        return res.toArray(new int[res.size()][]);


    }
//    public int[][] merge(int[][] intervals) {
//        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
//        List<int[]> res=new ArrayList<>();
//        int begin=intervals[0][0],end=intervals[0][1];
//        for(int i=1;i<intervals.length;i++){
//            if(intervals[i][0]<=end){
//                end= Math.max(end,intervals[i][1]);
//            }
//            else {
//                res.add(new int[]{begin,end});
//                begin=intervals[i][0];
//                end=intervals[i][1];
//            }
//        }
//        res.add(new int[]{begin,end});
//        return res.toArray(new int[res.size()][]);
//
//    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
        //输出：[[1,6],[8,10],[15,18]]
        //解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
        //示例 2：
        //
        //输入：intervals = [[1,4],[4,5]]
        //输出：[[1,5]]
        //解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
        //示例 3：
        //
        //输入：intervals = [[4,7],[1,4]]
        //输出：[[1,7]]
        //解释：区间 [1,4] 和 [4,7] 可被视为重叠区间。
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        No56 no56 = new No56();
        int[][] merge = no56.merge(intervals);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(merge[i][0] + " " + merge[i][1]);
        }
        System.out.println();
        int[][] intervals2 = {{1,4},{4,5}};
        int[][] merge2 = no56.merge(intervals2);
        for (int i = 0; i < merge2.length; i++) {
            System.out.println(merge2[i][0] + " " + merge2[i][1]);
        }

        System.out.println();
        int[][] intervals3 = {{4,7},{1,4}};
        int[][] merge3 = no56.merge(intervals3);
        for (int i = 0; i < merge3.length; i++) {
            System.out.println(merge3[i][0] + " " + merge3[i][1]);
        }
    }
}
