package src.tanxin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-05-28 23:17
 */
public class No56 {

    public int[][] merge(int[][] intervals) {

        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(intervals,(o1,o2)->o1[0]-o2[0]);
        int count=0,start=intervals[0][0],end=intervals[0][1];
        int i=1;
        while(i<intervals.length){
            if(intervals[i][0]>end){
                List<Integer> t=new ArrayList<>();
                t.add(start);
                t.add(end);
                res.add(new ArrayList<>(t));
                start=intervals[i][0];
                end=intervals[i][1];
                i++;

            }
            else {
                if (intervals[i][0]>=start&&intervals[i][0]<=end&&intervals[i][1]>end){
                    end=intervals[i][1];
                }
                i++;

            }
            if(i==intervals.length){
                List<Integer> t=new ArrayList<>();
                t.add(start);
                t.add(end);
                res.add(new ArrayList<>(t));
            }

        }
        int [][] r=new int[res.size()][2];
        for(int j=0;j<res.size();j++){
            r[count++]=new int[]{res.get(j).get(0),res.get(j).get(1)};
        }
        if(res.size()==0){
            r=new int[1][2];
            r[0]=new int[]{start,end};
        }

        return r;

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
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        No56 no56 = new No56();
        int[][] merge = no56.merge(intervals);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(merge[i][0] + " " + merge[i][1]);
        }
        System.out.println();
        int[][] intervals2 = {{1,3}};
        int[][] merge2 = no56.merge(intervals2);
        for (int i = 0; i < merge2.length; i++) {
            System.out.println(merge2[i][0] + " " + merge2[i][1]);
        }

    }
}
