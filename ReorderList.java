/*
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.
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
    public void reorderList(ListNode head) {
        List<ListNode> arr=getList(head);
        int n=arr.size();
        // for(ListNode t: arr) System.out.println(t.val+" "+t.next.val);
        int i=1, j=n-2;
        arr.get(0).next=arr.get(n-1);
        ListNode curr=arr.get(n-1);
        while(i<=j){
            curr.next=arr.get(i++);
            curr=curr.next;
            curr.next=arr.get(j--);
            curr=curr.next;
        }
        curr.next=null;
    }
    List<ListNode> getList(ListNode head){
        ListNode temp=head;
        List<ListNode> arr=new ArrayList<>();
        while(temp!=null){
            arr.add(temp);
            temp=temp.next;
        }
        return arr;
    }
}
