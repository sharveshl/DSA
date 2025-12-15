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
    public void preOrder(TreeNode root, int row, int col, ArrayList<int[]> result){
        if(root!=null){
            result.add(new int[]{col, row, root.val});
            preOrder(root.left, row+1, col-1, result);
            preOrder(root.right, row+1, col+1, result);
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        ArrayList<int[]> nodes = new ArrayList<>();
        preOrder(root, 0, 0, nodes);
        nodes.sort((a,b)->{
            if(a[0]!=b[0])
                return Integer.compare(a[0], b[0]);
            if(a[1]!=b[1])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });
        List<List<Integer>> result = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        List<Integer> level =  new ArrayList<>();
        for(int[] node : nodes){
            if(node[0]!=prevCol){
                if(prevCol!=Integer.MIN_VALUE){
                    result.add(level);
                }
                level = new ArrayList<>();
                prevCol = node[0];
            }
            level.add(node[2]);
        }
        result.add(level);
        return result;
    }
}