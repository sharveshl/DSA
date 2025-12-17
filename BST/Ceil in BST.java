/* class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Solution {
    int findCeil(Node root, int x) {
        // code here
        int ceil = -1;
        while(root!=null){
            if(root.data==x)
                return x;
            else if(x<root.data){
                ceil = root.data;
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return ceil;
    }
}
