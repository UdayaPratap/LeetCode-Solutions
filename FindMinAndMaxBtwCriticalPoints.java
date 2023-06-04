/*
A critical point in a linked list is defined as either a local maxima or a local minima.

A node is a local maxima if the current node has a value strictly greater than the previous node and the next node.

A node is a local minima if the current node has a value strictly smaller than the previous node and the next node.

Note that a node can only be a local maxima/minima if there exists both a previous node and a next node.

Given a linked list head, return an array of length 2 containing [minDistance, maxDistance] where minDistance is the minimum distance between any two distinct critical points and maxDistance is the maximum distance between any two distinct critical points. If there are fewer than two critical points, return [-1, -1].
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
   public int[] nodesBetweenCriticalPoints(ListNode h) {
    int first = Integer.MAX_VALUE, last = 0, prev_val = h.val, min_d = Integer.MAX_VALUE;
    int i=0;
    while(h.next!=null){
        if ((prev_val < h.val && h.val > h.next.val) || 
            (prev_val > h.val && h.val < h.next.val)) {
            if (last != 0)
                min_d = Math.min(min_d, i - last);
            first = Math.min(first, i);
            last = i;
        }
        prev_val = h.val;
        h = h.next;
        i++;
    }        
    if (min_d == Integer.MAX_VALUE)
        return new int[] {-1, -1};
    return new int[] {min_d, last - first};
}
}
