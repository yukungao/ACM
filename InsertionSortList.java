/* http://www.lintcode.com/en/problem/insertion-sort-list/# */
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
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here

        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(Integer.MIN_VALUE);

        while(head != null) {

            // Search from the begining
            ListNode iter = dummy;
            while(iter.next != null && iter.next.val < head.val) {
                iter = iter.next;
            }
            // Find the point where iter.next.val > head.val, so
            // the head should insert into the iter.next.

            //Step 1: Store the head.next
            ListNode holdNext = head.next;
            //Step 2: head.next = iter.next;
            head.next = iter.next;
            //Step 3: iter.next = head, finish the insertion
            iter.next = head;
            //Step 4: Advance the head;
            head = holdNext;
        }
        return dummy.next;
    }


}
