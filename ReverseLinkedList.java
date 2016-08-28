/* http://www.lintcode.com/en/problem/reverse-linked-list/ */

// Iterative Way
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
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        // Empty list or single node list, return head.
        if(head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode post = curr.next;
            curr.next = pre;
            pre = curr;
            curr = post;
        }

        return pre;
    }
}
