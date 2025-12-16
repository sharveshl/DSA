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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inmp = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inmp.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, inmp);

    }
    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> inmp){
        if(preStart>preEnd || inStart>inEnd){
            return null;
        }
        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);
        int x = inmp.get(val);
        int numsLeft = x-inStart;
        root.left = build(preorder, preStart+1, preStart+numsLeft, inorder, inStart, x-1, inmp);
        root.right = build(preorder, preStart+numsLeft+1, preEnd, inorder, x+1, inEnd, inmp);
        return root;
    }
}