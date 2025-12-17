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
    public boolean isValidBSTUtil(TreeNode root, long x, long y){
        if(root==null)
            return true;
        if(!(root.val>x && root.val<y)) return false;
        return isValidBSTUtil(root.left, x, root.val) && isValidBSTUtil(root.right, root.val, y);
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
