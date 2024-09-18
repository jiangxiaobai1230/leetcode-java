package src.tanxin;

import src.BinaryTree.TreeNode;

/**
 * @author: Yuan Yuqing
 * @date: 2024-05-29 22:39
 */
public class No968 {

    int count=0;


    public int minCameraCover(TreeNode root) {
        if(minCam(root)==1){
            count++;
        }

        return count;

    }

    //1无覆盖
    //2有摄像头
    //3有覆盖
    public int minCam(TreeNode root){
        if(root==null){
            return 3;
        }
        int left=minCam(root.left);
        int right=minCam(root.right);
        if(left==3&&right==3){
            return 1;
        } else if (left==1||right==1) {
            count++;
            return 2;

        }else {
            return 3;

        }


    }


    public static void main(String[] args) {

        //示例 1：
        //
        //
        //
        //输入：[0,0,null,0,0]
        //输出：1
        //解释：如图所示，一台摄像头足以监控所有节点。
        //示例 2：
        //
        //
        //
        //输入：[0,0,null,0,null,0,null,null,0]
        //输出：2
        //解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。


        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);

        System.out.println(new No968().minCameraCover(root));

        TreeNode root2 = new TreeNode(0);
        root2.left = new TreeNode(0);
        root2.left.left = new TreeNode(0);
        root2.left.left.left = new TreeNode(0);
        root2.left.left.left.right = new TreeNode(0);
        System.out.println(new No968().minCameraCover(root2));

    }
}
