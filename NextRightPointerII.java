/* https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/ */
public void connect(TreeLinkNode root) {
        if(root == null) return;
        /* Do the level order traversal but build on the fly */
        bfs(root);
    }

    private void bfs(TreeLinkNode root) {
        /* Need to new a dummyHead like linkedlist trick*/
        TreeLinkNode currHead = new TreeLinkNode(0);
        currHead.next = root;

        while(currHead.next != null) {
            TreeLinkNode currItr = currHead.next;
            /* Need to new a dummyHead */
            TreeLinkNode nextHead = new TreeLinkNode(0);
            TreeLinkNode nextItr = nextHead;

            while(currItr != null) {
                if(currItr.left != null) {
                    nextItr.next = currItr.left;
                    nextItr = nextItr.next;
                }
                if(currItr.right != null) {
                    nextItr.next = currItr.right;
                    nextItr = nextItr.next;
                }
                currItr = currItr.next;
            }

            currHead = nextHead;
        }
    }
