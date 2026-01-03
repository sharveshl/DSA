/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class Solution {
    PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> a.data-b.data);
    public void util(Node root){
        if(root!=null){
            pq.add(root);
            util(root.bottom);
            util(root.next);
        }
    }
    public Node flatten(Node root) {
        // code here
        util(root);
        Node dummy = new Node(0);
        Node temp = dummy;
        while(!pq.isEmpty()){
            temp.bottom = pq.poll();
            temp = temp.bottom;
        }
        return dummy.bottom;
        
    }
}
