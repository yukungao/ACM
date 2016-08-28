/* http://www.lintcode.com/en/problem/intersection-of-two-linked-lists/# */
// Corner Case !! Check if headA equal headB first.
// Since the monment you put p1,p2 at head,you ignore the head.

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
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Write your code here
        if(headA == null || headB == null) return null;

        // Put P1 at the headA
        ListNode p1 = headA;
        ListNode p2 = headB;

        // Corner case!
        if(p1 == p2) return p1;

        while(p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        if(p1 == null && p2 == null) {
            return null;
        } else if(p1 == null) {
            p1 = headB;
            while(p2 != null) {
                p2 = p2.next;
                p1 = p1.next;
            }
            //Put p2 at the headA
            p2 = headA;
        } else {
            p2 = headA;
            while(p1 != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            p1 = headB;
        }


        while(p1 != null && p2 != null) {
            if(p1 == p2) {
                return p1;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }

        return null;
    }
}
