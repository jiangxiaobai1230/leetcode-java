package src.tanxin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-05-18 21:51
 */
public class No406 {


    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(o1,o2)->o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0]);
        List<int[]> res=new ArrayList<>();
        for(int i=0;i<people.length;i++){
            res.add(people[i][1],people[i]);
        }
        return res.toArray(new int[res.size()][2]);


    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
        //输出：[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
        //解释：
        //编号为 0 的人身高为 5 ，没有身高更高或者相同的人排在他前面。
        //编号为 1 的人身高为 7 ，没有身高更高或者相同的人排在他前面。
        //编号为 2 的人身高为 5 ，有 2 个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
        //编号为 3 的人身高为 6 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
        //编号为 4 的人身高为 4 ，有 4 个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
        //编号为 5 的人身高为 7 ，有 1 个身高更高或者相同的人排在他前面，即编号为 1 的人。
        //因此 [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] 是重新构造后的队列。
        //示例 2：
        //
        //输入：people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
        //输出：[[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
        //

        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        No406 no406 = new No406();
        int[][] result = no406.reconstructQueue(people);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
        System.out.println();
        people = new int[][]{{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}};
        result = no406.reconstructQueue(people);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
        System.out.println();

    }
}
