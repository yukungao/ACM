/* http://www.lintcode.com/en/problem/partition-list/ */
/*
  KeyNote: should do the l2.next = null, otherwise, will cause
  Memory Limit error.

*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        // Make two head;
        if(head == null) return null;

        // List head1 store value <= target
        ListNode l1 = new ListNode(0);
        ListNode head1 = l1;

        // List head2 store value > target
        ListNode l2 = new ListNode(0);
        ListNode head2 = l2;


        while(head != null) {
            if(head.val < x) {
                l1.next = head;
                l1 = l1.next;
            } else {
                l2.next = head;
                l2 = l2.next;
            }

            head = head.next;
        }

        // Merge two list:
        // This
        l2.next = null;
        l1.next = head2.next;

        return head1.next;
    }
}
