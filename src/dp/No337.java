package src.dp;


import java.util.HashMap;

/**
 * @author: Yuan Yuqing
 * @date: 2024-07-13 21:07
 */
public class No337 {



    public int rob(TreeNode root) {
        HashMap<TreeNode,Integer> map=new HashMap<>();
        return robInternal(root,map);
    }
    public int robInternal(TreeNode root,HashMap<TreeNode,Integer> map) {
        if(root==null)return 0;
        if(map.containsKey(root))return map.get(root);
        int money=root.val;
        if(root.left!=null){
            money+=robInternal(root.left.left,map)+robInternal(root.left.right,map);
        }
        if(root.right!=null){
            money+=robInternal(root.right.left,map)+robInternal(root.right.right,map);
        }
        int sonMoney=robInternal(root.left,map)+robInternal(root.right,map);
        int result=Math.max(money,sonMoney);
        map.put(root,result);
        return result;


    }

    public static void main(String[] args) {
        //示例 1:
        //
        //
        //
        //输入: root = [3,2,3,null,3,null,1]
        //输出: 7
        //解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
        //示例 2:
        //
        //
        //
        //输入: root = [3,4,5,1,3,null,1]
        //输出: 9
        //解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
        //

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(new No337().rob(root));

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.right = new TreeNode(1);
        System.out.println(new No337().rob(root1));




    }

}
