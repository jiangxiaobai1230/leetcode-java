package src.hot100;

/**
 * @author: Yuan Yuqing
 * @date: 2025-03-04 23:49
 */
public class No105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode build(int[] preorder, int l,int r,int[] inorder,int m,int n) {
        if(l>r||m>n)return null;
        int node=preorder[l];
        int index=m;
        for(int i=m;i<=n;i++){
            if(node==inorder[i]){
                index=i;
                break;
            }
        }
        TreeNode root=new TreeNode(node);
        root.left=build(preorder,l+1,r,inorder,m,index-1);
        root.right=build(preorder,l+index-m+1,r,inorder,index+1,n);
        return root;

    }


    public static void main(String[] args) {
        //输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        //输出: [3,9,20,null,null,15,7]
        //示例 2:
        //
        //输入: preorder = [-1], inorder = [-1]
        //输出: [-1]
        int[] preorder1 = {3, 9, 20, 15, 7};
        int[] inorder1 = {9, 3, 15, 20, 7};
        int[] preorder2 = {-1};
        int[] inorder2 = {-1};
        TreeNode res1 = new No105().buildTree(preorder1, inorder1);
        TreeNode res2 = new No105().buildTree(preorder2, inorder2);
        while (res1 != null) {
            System.out.println(res1.val);
            res1 = res1.left;
        }
        System.out.println();
        while (res2 != null) {
            System.out.println(res2.val);
            res2 = res2.left;
        }

    }
}
