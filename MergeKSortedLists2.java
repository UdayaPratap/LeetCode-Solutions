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
        if (lists == null || lists.length == 0) {
            return null;
        }
        return picker(lists, 0, lists.length-1);
    }
    ListNode picker(ListNode[] lists, int left, int right)
    {
        if(left==right) return lists[left];
        if(left>right) return null;
        // ListNode l1=picker(lists, left+1, right-1);
        // return merge(l1, merge(lists[left], lists[right]));
        int mid=left+ (right-left)/2;
        ListNode l1=picker(lists, left, mid);
        ListNode l2=picker(lists, mid+1, right);
        return merge(l1, l2);
    }
    ListNode merge(ListNode head1, ListNode head2)
    {  
        if(head1==null && head2==null) return null;
        if(head1==null) return head2;
        if(head2==null) return head1;
         ListNode head= head1.val<head2.val? head1: head2;
        ListNode curr=new ListNode(0);
        while(head1!=null && head2!=null){
            if(head1.val<head2.val){
                curr.next=head1;
                head1=head1.next;
            }else{
                curr.next=head2;
                head2=head2.next;
            }
            curr=curr.next;
        }
        curr.next= head1==null? head2 : head1;
        return head;
    }
}
