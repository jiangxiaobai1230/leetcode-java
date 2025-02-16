package src.hot100;

import java.util.*;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-22 12:42
 */
public class No207 {
    //https://leetcode.cn/problems/course-schedule/solutions/18806/course-schedule-tuo-bu-pai-xu-bfsdfsliang-chong-fa/comments/2299421

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees=new int[numCourses];//每个课程的入度
        Map<Integer, List<Integer>> adjacency=new HashMap();
        for (int i=0;i<numCourses;i++) {
            adjacency.put(i,new ArrayList<>());//每个课程维护一个list，用于存放后修课程
        }
        for (int[] prerequisite : prerequisites) {
            indegrees[prerequisite[0]]++;//有先修课程，入度加一
            adjacency.get(prerequisite[1]).add(prerequisite[0]);//在先修课程的list添加后修课程
        }
        Queue<Integer> queue=new LinkedList<>();
        for (int i=0;i<numCourses;i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }//将入度为0的课程放入队列
        while(!queue.isEmpty()){
            for(int i= queue.size();i>0;i--){
                Integer poll = queue.poll();
                numCourses--;
                List<Integer> integers = adjacency.get(poll);//取出这个课程维护的list
                for (Integer integer : integers) {
                    indegrees[integer]--;//将list中的课程的入度-1
                    if(indegrees[integer]==0){
                        queue.add(integer);//如果入度为零则可以学习，加入到下一轮的队列中
                    }
                }
            }

        }
        return numCourses == 0;


    }


    public static void main(String[] args) {
        //示例 1：
        //
        //输入：numCourses = 2, prerequisites = [[1,0]]
        //输出：true
        //解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
        //示例 2：
        //
        //输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
        //输出：false
        //解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。

        System.out.println(new No207().canFinish(3, new int[][]{{1,0},{1,2},{0,1}}));
        System.out.println(new No207().canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }
}
