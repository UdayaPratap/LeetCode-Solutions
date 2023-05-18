/*
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 
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
    public ListNode swapPairs(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode left=null, n1=head, n2=head.next, right=head.next!=null? head.next.next : null;
        while(n2!=null){
            //starting nodes
            if(left==null){
                n1.next=right;
                n2.next=n1;
                head=n2;
            }
            else{
                left.next=n2;
                n2.next=n1;
                n1.next=right;
            }
            left=n1;
            n1=left.next;
            n2=(n1!=null? n1.next : null);
            right=(n2!=null? n2.next : null);

        }
        return head;
    }
}
