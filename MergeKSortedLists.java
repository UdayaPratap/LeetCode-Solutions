/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.
*/
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
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        for(ListNode head : lists)
        {
            while(head!=null)
            {
                heap.add(head.val);
                head=head.next;
            }
        }
        ListNode head=new ListNode();
        if(heap.isEmpty())
        {
            return null;
        }
        head.val=heap.poll();
         ListNode tail=head;
         tail.next=null;
        while(!heap.isEmpty())
        {
                tail.next=new ListNode(heap.poll());
                tail=tail.next;
        }
        return head;
    }
}
