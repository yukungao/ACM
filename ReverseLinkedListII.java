/* http://www.lintcode.com/en/problem/reverse-linked-list-ii/# */
// One-pass,

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
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {

        // Corner case that don't need to reverse
        if(head == null || head.next == null || n <= m) return head;
        ListNode preM = new ListNode(-1);
        preM.next = head;
        ListNode dummy = preM;

        ListNode curr = head;
        // Step 1: Put prev before mth Node
        //         Put curr at mth Node
        int i = 1;
        for(; i < m; i++) {
            preM = curr;
            curr = curr.next;
        }

        ListNode pre = curr;
        curr = curr.next;
        ListNode post = null;

        while(i < n && curr != null) {
            post = curr.next;
            curr.next = pre;
            pre = curr;
            curr = post;
            i++;
        }

        preM.next.next = post;
        preM.next = pre;

        return dummy.next;
    }
}
