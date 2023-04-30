/*
In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
The twin sum is defined as the sum of a node and its twin.

Given the head of a linked list with even length, return the maximum twin sum of the linked list.
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
    public int pairSum(ListNode head) {
        ListNode mid=findMid(head);
        ListNode head2=reverse(mid);
        int max=-1;
        while(head!=null && head2!=null)
        {
            max=Math.max(max, head.val+head2.val);
            head=head.next;
            head2=head2.next;
        }
        return max;
    }
    ListNode findMid(ListNode head)
    {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    ListNode reverse(ListNode head)
    {
        ListNode temp=head, temp2=head.next;
        head.next=null;
        while(temp2!=null){
            ListNode temp3=temp2.next;
            temp2.next=temp;
            temp=temp2;
            temp2=temp3;
        }
        return temp;
    }
}
