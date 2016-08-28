/* http://www.lintcode.com/en/problem/add-two-numbers/# */
/**
 * Definition for singly-linked list.
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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;

        ListNode head_1 = l1;
        ListNode head_2 = l2;
        // Create a dummy node
        ListNode res = new ListNode(0);
        ListNode head = res;

        int carray = 0;
        int sum = 0;

        while(head_1 != null && head_2 !=null ) {
            sum = (head_1.val + head_2.val + carray)%10;
            carray = (head_1.val + head_2.val + carray)/10;
            res.next = new ListNode(sum);
            res = res.next;
            head_1 = head_1.next;
            head_2 = head_2.next;
        }

        // Blindly add, instead of check if (head1 == null) or (head2 == null)
        while( head_1 != null) {
            sum = (head_1.val + carray)%10;
            carray = (head_1.val + carray)/10;
            res.next = new ListNode(sum);
            res = res.next;
            head_1 = head_1.next;
        }
        //
        while (head_2 != null) {
            sum = (head_2.val + carray)%10;
            carray = (head_2.val + carray)/10;
            res.next = new ListNode(sum);
            res = res.next;
            head_2 = head_2.next;
        }

        if(carray != 0) {
            res.next = new ListNode(carray);
        }

        return head.next;
    }
}
