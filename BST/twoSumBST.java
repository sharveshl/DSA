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
    public boolean util(TreeNode root, int k, HashMap<Integer, Integer> mp){
        if(root==null) return false;
        int val = k-root.val;
        if(mp.containsKey(val)) return true;
        else{
            mp.put(val,1);
            mp.put(root.val,1);
        }
        return util(root.left, k, mp) || util(root.right, k, mp);
    }
    public boolean findTarget(TreeNode root, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        return util(root, k, mp);
    }
}
