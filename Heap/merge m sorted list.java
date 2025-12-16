/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode i:lists)
        {
            if(i!=null)
                pq.add(i);
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(!pq.isEmpty()){
            ListNode smallest = pq.poll();
            temp.next = smallest;
            temp = temp.next;
            if(smallest.next!=null)
                pq.add(smallest.next);
        }
        return dummy.next;
    }
}
