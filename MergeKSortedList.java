/* http://www.lintcode.com/en/problem/merge-k-sorted-lists/# */

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
  1. The merge sort: One trick in merge two sorted list part, if val1 < val2,
  point to val1, else we could directly point to val2.Not need to care val1 == val2
  condition
*/

// Merge sort idea
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if(lists == null || lists.size() == 0) return null;
        return mergeHelper(lists, 0, lists.size() - 1);
    }

    private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
        if(start == end) {
            return lists.get(start);
        }

        int mid = start + (end - start)/2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid+1, end);
        return mergeTwoList(left, right);

    }

    public ListNode mergeTwoList(ListNode head1, ListNode head2) {
        //Step 1: Create a dummy head
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        //Step 2: keep the tail pointer so that to point to the next node
        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                tail.next = head1;
                tail = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                tail = head2;
                head2 = head2.next;
            }
        }

        if(head1 != null) {
            tail.next = head1;
        }

        if(head2 != null) {
            tail.next = head2;
        }
        return dummy.next;
    }
}

// Heap idea

// Step 1: Create a priority queue(increasing based on the value of node) and push K heads into this q;
// Step 2:
// Step 3:

public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if(lists == null || lists.size() == 0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(),
        new Comparator<ListNode>() {
            public int compare(ListNode node1, ListNode node2) {
                if(node1 == null) {
                    return 1;
                } else if (node2 == null) {
                    return -1;
                } else {
                    return node1.val - node2.val;
                }
            }
        });

        for(int i = 0; i < lists.size(); i++ ) {
            if(lists.get(i) != null) {
                pq.offer(lists.get(i));
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        // Put everything in the list
        while(!pq.isEmpty()) {
            ListNode head = pq.poll();
            tail.next = head;
            tail = head;
            if(head.next != null) {
                pq.offer(head.next);
            }
        }

        return dummy.next;
    }
}
