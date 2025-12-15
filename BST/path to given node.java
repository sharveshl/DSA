/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    ArrayList<Integer> result = new ArrayList<>();
    public boolean check(TreeNode root, int target){
        if(root==null)
            return false;
        result.add(root.val);
        if(root.val==target)
            return true;
        if(check(root.left, target) || check(root.right, target))
            return true;
        result.remove(result.size()-1);
        return false;
    }
    public ArrayList<Integer> solve(TreeNode A, int B) {
        check(A,B);
        return result;
    }
}
