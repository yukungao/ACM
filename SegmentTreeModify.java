/* http://www.lintcode.com/en/problem/segment-tree-modify/# */
// Query from top->down, update from down-->top

public class Solution {
    /**
     *@param root, index, value: The root of segment tree and
     *@ change the node's value with [index, index] to the new given value
     *@return: void
     */
    public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
        if(root.start == index && root.end == index) {
            root.max = value;
            return;
        }

        int mid = (root.end + root.start)/2;

        // Divide
        if(root.start <= index && index <= mid) {
            modify(root.left, index, value);

        }
        // You shouldn't use mid <= index, why? That's because
        // Left node: start=A.left, end=(A.left + A.right) / 2
        // Rigth node: start=(A.left + A.right) / 2 + 1, end=A.right
        if(mid < index && index <= root.end) {
            modify(root.right, index, value);
        }
        // Conquer
        root.max = Math.max(root.left.max, root.right.max);

    }
}
