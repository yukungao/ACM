/* http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-list/ */

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if(head == null || head.next == null) return head;

        // Made a dummy header
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        
        while(head.next != null) {
            if(head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return dummy.next;
    }
}
