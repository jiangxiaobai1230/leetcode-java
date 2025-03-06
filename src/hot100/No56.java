package src.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-04 22:00
 */
public class No56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> nums=new ArrayList<>();
        Arrays.sort(intervals, (p, q) -> p[0] - q[0]); // 按照左端点从小到大排序
        int start=intervals[0][0],end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>end){
                nums.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }else {
                end=Math.max(intervals[i][1],end);
            }
        }
        nums.add(new int[]{start,end});
        return nums.toArray(new int[nums.size()][2]);

    }

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
        System.out.println(new No56().merge(new int[][]{{1, 4}, {0,4}}));
        System.out.println(new No56().merge(new int[][]{{1, 4}, {4, 5}}));

    }
}
