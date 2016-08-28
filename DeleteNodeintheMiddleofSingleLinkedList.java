/* http://www.lintcode.com/en/problem/delete-node-in-the-middle-of-singly-linked-list/ */
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

 /*
 
  1 ->  2  -->  3  -->  4
        |       |       |
      Node   nextNode   nextNode.next;

      Step 1: Node.val = nextNode.val;
      Step 2: Node.next = nextNode.next;
 */
public class Solution {
    /**
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        // write your code here

        // Empty list or signal node.
        if(node == null || node.next == null) return;
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;

        return;
    }
}
