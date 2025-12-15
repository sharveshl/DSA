/*
class Node {
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/

class Solution {
    Node lca(Node root, int p, int q) {
        // code here
         if(root==null || root.data==p || root.data==q)
            return root;
        Node lcal = lca(root.left, p, q);
        Node rcal = lca(root.right, p, q);
        if(lcal==null)
            return rcal;
        if(rcal==null)
            return lcal;
        return root;
    }
}