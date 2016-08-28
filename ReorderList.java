/* http://www.lintcode.com/en/problem/reorder-list/ */
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
     * @return: void
     */
    public void reorderList(ListNode head) {
        // write your code here
        if(head == null || head.next == null ) return;

        // Get the length of LinkedList
        int length = 0;

        ListNode iter = head;
        while(iter != null) {
            length++;
            iter = iter.next;
        }

        // Right now the is at the mid;
        ListNode preMid = head;
        for(int i = 1; i < length/2; i++) {
            preMid = preMid.next;
        }


        ListNode mid = preMid.next;
        preMid.next = null;

        // Reverse the linked list from mid;
        ListNode newHead = null;
        while(mid != null) {
            ListNode postMid = mid.next;
            mid.next = newHead;
            newHead = mid;
            mid = postMid;
        }

        //So far the newHead is the head of list2
        // Then we can merge now.
        // One corner case is that p1->next = null
        ListNode p1 = head;
        ListNode p2 = newHead;

        // stop instead of p1 & p2
        while(p1.next != null && p2.next != null) {

            ListNode postP1 = p1.next;
            ListNode postP2 = p2.next;

            p2.next = p1.next;
            p1.next = p2;

            p1 = postP1;
            p2 = postP2;

        }
        // Corner Case
        if(p1.next == null) {
            p1.next = p2;
        }

    }
}
