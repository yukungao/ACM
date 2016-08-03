/* http://www.lintcode.com/en/problem/reverse-linked-list/ */

/*
Recursive way,

1. Return What? The header of new list, which is the lastNode in original list. How to make sure it
returns finally? Just keep pop it up once found ! That's why the currNode doesn't get any modification at all

2. Pre-dfs processing or Post-dfs preprocessiong, In current solution, use post preprocessiong
Why? because when you pop the stack, you can revser the pointer say  head->head.next ==> head.next -> head

However,

*/
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if(head == null || head.next == null) {
            return head;
        }

        // remaining is the res of sub-problem (remaining part)
        ListNode remaining = reverse(head.next);

        // Once the sub-problem is solve, what about current level
        // current level is simply reverse, that's it

        head.next.next = head;
        //Not sure why need this null setting? How does it works?
        // I got a feeling, when it goes down, the current node's next doesn't care
        // It will stitching to correct answer during pop up anyway.
        head.next = null;

        // The currNode has not been changed during pop(), thus it's the header.
        return remaining;
    }
}
