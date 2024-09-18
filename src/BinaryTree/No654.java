package src.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-17 10:04
 */
public class No654 {


    public TreeNode constructMaximumBinaryTree(int[] nums) {


        return getMax(nums,0,nums.length-1);

    }

    public TreeNode getMax(int[] nums,int begin,int end){
        int maxIndex=-1,max=-1;
        if(begin>end|| begin<0 ||end<0)return new TreeNode(-1);
        for(int i=begin;i<=end;i++){
            if(max<nums[i]){
                max=nums[i];
                maxIndex=i;
            }

        }
        if(maxIndex>=0){
            TreeNode node=new TreeNode(max);
            node.left=getMax(nums,begin,maxIndex-1);
            node.right=getMax(nums,maxIndex+1,end);

            return node;

        }else return new TreeNode(-1);


    }
    public void bfs(TreeNode root){
        if(root == null){
            System.out.println("null");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }



    }
    //层次遍历


    public static void main(String[] args) {

        //输入：nums = [3,2,1,6,0,5]
        //输出：[6,3,5,null,2,0,null,null,1]
        //解释：递归调用如下所示：
        //- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
        //    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
        //        - 空数组，无子节点。
        //        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
        //            - 空数组，无子节点。
        //            - 只有一个元素，所以子节点是一个值为 1 的节点。
        //    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
        //        - 只有一个元素，所以子节点是一个值为 0 的节点。
        //        - 空数组，无子节点。
        //示例 2：
        //
        //
        //输入：nums = [3,2,1]
        //输出：[3,null,2,null,1]

        int[] nums = {3,2,1,6,0,5};
        No654 no654 = new No654();
        TreeNode treeNode = no654.constructMaximumBinaryTree(nums);
        no654.bfs(treeNode);
        System.out.println();


        nums = new int[]{3,2,1};
        treeNode = no654.constructMaximumBinaryTree(nums);
        no654.bfs(treeNode);




    }
}
