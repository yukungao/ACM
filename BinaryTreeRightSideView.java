/* https://leetcode.com/problems/binary-tree-right-side-view/ */

public List<Integer> rightSideView(TreeNode root) {
       List<Integer> res = new ArrayList<Integer>();
       if(root == null) return res;

       Queue <TreeNode> currLevel = new LinkedList<TreeNode>();
       Queue <TreeNode> nextLevel = new LinkedList<TreeNode>();

       currLevel.offer(root);

       while(!currLevel.isEmpty()) {
           TreeNode curr = currLevel.poll();

           // Last elemnt at this level, we need to add it to res;
           if(currLevel.isEmpty()) {
               res.add(curr.val);
           }

           if(curr.left != null) {
               nextLevel.offer(curr.left);
           }

           if(curr.right != null) {
               nextLevel.offer(curr.right);
           }


           if(currLevel.isEmpty()) {
               //Swap the currLevel and nextLevel, then clear currLevel;
               Queue tmp = currLevel;
               currLevel = nextLevel;
               nextLevel = tmp;
               nextLevel.clear();
           }

       }

       return res;
   }
