/* http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-list-ii/# */

/*
This time we need to only keep distinct number, so we need another pointer called pre.
The pre behavior depends on if duplicates has found, thus we have another flag called
foundDup.
*/

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
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if(head == null || head.next == null) return head;

        // Made a dummy header
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        boolean foundDup = false;
        while(head.next != null) {
            if(head.val == head.next.val) {
                head.next = head.next.next;
                foundDup = true;
            } else {
                if(foundDup == true) {
                    pre.next = head.next;
                    foundDup = false;
                } else {
                    pre = head;
                }
                head = head.next;
            }
        }

        // The last element is dup (This is the corner case)
        if(foundDup == true) {
             pre.next = head.next;
        }

        return dummy.next;
    }
}
