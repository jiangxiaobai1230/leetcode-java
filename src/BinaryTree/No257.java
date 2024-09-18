package src.BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yuan Yuqing
 * @date: 2024-04-11 22:18
 */
public class No257 {
    private List<String> res=new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> path=new ArrayList<>();
        traversal(root,path);
        return res;
    }
    public void traversal(TreeNode root,List<Integer> path){
        path.add(root.val);
        if(root.left==null&& root.right==null){
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<path.size()-1;i++){
                sb.append(path.get(i).toString());
                sb.append("->");
            }
            sb.append(path.get(path.size()-1).toString());
            res.add(sb.toString());
            return;

        }
        if(root.left!=null){
            traversal(root.left,path);
            path.remove(path.size()-1);
        }
        if(root.right!=null){
            traversal(root.right,path);
            path.remove(path.size()-1);
        }



    }

    public static void main(String[] args) {

        //输入：root = [1,2,3,null,5]
        //输出：["1->2->5","1->3"]
        //示例 2：
        //
        //输入：root = [1]
        //输出：["1"]

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        List<String> list = new No257().binaryTreePaths(root);
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("==========");


        TreeNode root2 = new TreeNode(1);
        List<String> list2 = new No257().binaryTreePaths(root2);
        for (String s : list2) {
            System.out.println(s);
        }


    }
}
