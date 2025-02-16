package src.hot100;



import src.dp.TreeNode;

import java.util.HashMap;
import java.util.Locale;

/**
 * @author: Yuan Yuqing
 * @date: 2025-01-20 23:17
 */
public class No437 {
    //https://leetcode.cn/problems/path-sum-iii/solutions/1021776/tong-ge-lai-shua-ti-la-qian-zhui-he-tu-j-trcq/?envType=study-plan-v2&envId=top-100-liked
    //第一反应回溯！！！
    int res;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)return 0;
        HashMap<Long,Integer> map=new HashMap<>();
        map.put(0L,1);
        dfs(root,0L,map,targetSum);
        return res;

    }
    void dfs(TreeNode node, Long curNum, HashMap<Long,Integer> map,int target){
        if(node==null)return;
        curNum+=node.getVal();
        res+=map.getOrDefault(curNum-target,0);

        map.put(curNum,map.getOrDefault(curNum,0)+1);

        dfs(node.left,curNum,map,target);
        dfs(node.right,curNum,map,target);
        map.put(curNum,map.getOrDefault(curNum,0)-1);

    }

    public static void main(String[] args) {
        //输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
        //输出：3
        //解释：和等于 8 的路径有 3 条，如图所示。
        //示例 2：
        //
        //输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
        //输出：3

        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(-3);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(11);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(-2);
        TreeNode node8 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.right = node8;
        No437 no437 = new No437();
        System.out.println(no437.pathSum(root, 8));

    }
}
