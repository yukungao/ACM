/* http://www.lintcode.com/en/problem/nth-to-last-node-in-list/# */


//==============
// Iterative way
//==============

public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list.
     */

    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        if(n < 0 || head == null) {
            return null;
        }

        // Two pointer, p2 is n node ahead of p1, once p2 reach the end of list
        // p1 is the result;

        ListNode p2 = head;
        for(int i = 0; i < n && p2 != null; i++) {
            p2 = p2.next;
        }

        ListNode p1 = head;
        while(p2 != null) {
                p1 = p1.next;
                p2 = p2.next;
        }

        return p1;
        
    }

}





//============
// Recursive way, need global variable, since the value++ after pop stack,
// the counter before entering stack couldn't be used...
//============
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
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list.
     */
    static int cnt = 0;

    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        if(n < 0 || head == null) {
            return null;

        }

        return dfs(head, n);
    }

    ListNode dfs(ListNode head, int target) {

        ListNode res =  head;
        if(head  == null) return null ;

        res = dfs(head.next, target);

        // Pop from the stack then cnt++
        cnt++;

        if(cnt == target) {
            res = head;
        }

        return res;
    }
}
