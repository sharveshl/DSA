/*
class Node {
    int data;
    Node left, right;

    Node(int val)
    {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public static int floor(Node root, int x) {
        // code here
        int floor = -1;
        while(root!=null){
            if(root.data==x) 
                return x;
            else if(root.data<x){
                floor = root.data;
                root = root.right;
            }
            else
                root = root.left;
        }
        return floor;
    }
}
