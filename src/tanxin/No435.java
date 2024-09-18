package src.tanxin;

import java.util.Arrays;

/**
 * @author: Yuan Yuqing
 * @date: 2024-05-27 21:48
 */
public class No435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2)->o1[1]-o2[1]);
        int count=1;
        int end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=end) {
                end=intervals[i][1];
                count++;
            }
        }
        return intervals.length-count;

    }

    public static void main(String[] args) {

        //示例 1:
        //
        //输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
        //输出: 1
        //解释: 移除 [1,3] 后，剩下的区间没有重叠。
        //示例 2:
        //
        //输入: intervals = [ [1,2], [1,2], [1,2] ]
        //输出: 2
        //解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
        //示例 3:
        //
        //输入: intervals = [ [1,2], [2,3] ]
        //输出: 0
        //解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
        int[][] intervals = new int[][]{{1,2},{2,3},{3,4},{1,3}};
        No435 no435 = new No435();
        System.out.println(no435.eraseOverlapIntervals(intervals));
        System.out.println(no435.eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2}}));
        System.out.println(no435.eraseOverlapIntervals(new int[][]{{1,2},{2,3}}));

        //[[-52,31],[-73,-26],[82,97],[-65,-11],[-62,-49],[95,99],[58,95],[-31,49],[66,98],[-63,2],[30,47],[-40,-26]]
        System.out.println(no435.eraseOverlapIntervals(new int[][]{{-52,31},{-73,-26},{82,97},{-65,-11},{-62,-49},{95,99},{58,95},{-31,49},{66,98},{-63,2},{30,47},{-40,-26}}));

    }
}
