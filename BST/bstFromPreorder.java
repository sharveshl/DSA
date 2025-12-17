/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int idx = 0;
    public TreeNode util(int[] preorder, long x, long y){
        if(idx>=preorder.length || preorder[idx]<x || preorder[idx]>y)
            return null;
        TreeNode root = new TreeNode(preorder[idx]);
        idx+=1;
        root.left = util(preorder, x, root.val);
        root.right = util(preorder, root.val, y);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int x = Integer.MIN_VALUE;
        int y = Integer.MAX_VALUE;
        return util(preorder,x, y);
    }
}
