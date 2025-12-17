/*
class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution {
    // return the Kth largest element in the given BST rooted at 'root'
    int count = 0;
    int result = -1;;
    public void inorder(Node root, int k){
        if(root!=null){
            inorder(root.right, k);
            count++;
            if(count==k){
                result = root.data;
                return;
            }
            inorder(root.left, k);
        }
    }
    public int kthLargest(Node root, int k) {
        // Your code here
        inorder(root, k);
        count = 0;
        int t = result;
        result = 0;
        return t;
        
    }
}
