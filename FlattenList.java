/* http://www.lintcode.com/en/problem/flatten-list/# */
/* Non-recursion version
The non-recursion version is quite like
http://www.lintcode.com/en/problem/flatten-nested-list-iterator/
push backwarsely 
*/
public List<Integer> flatten(List<NestedInteger> nestedList) {
       // Write your code here
       List<Integer> res = new ArrayList<Integer>();
       Stack<NestedInteger> stk = new Stack<NestedInteger>();

       if(nestedList == null || nestedList.size() == 0) {
           return res;
       }

       // Put everything into the stack first,revsersly
       // Since we want origin first become first when iterate
       for(int i = nestedList.size() - 1; i >= 0; i--) {
           stk.push(nestedList.get(i));
       }

       while(!stk.isEmpty()) {
           if (stk.peek().isInteger()) {
               res.add(stk.pop().getInteger());
           } else {
               NestedInteger currNode = stk.pop();
               for(int i = currNode.getList().size() - 1; i >= 0; i--) {
                   stk.push(currNode.getList().get(i));
               }
           }

       }

       return res;

   }

/* Typical DFS Version */
public class Solution {

    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> res = new ArrayList<Integer>();

        if(nestedList == null || nestedList.size() == 0) {
            return res;
        }

        for(NestedInteger element : nestedList){
            dfs(element, res);
        }

        return res;

    }
    private void dfs( NestedInteger element, List<Integer> res) {
        if(element.isInteger()) {
            res.add(element.getInteger());
        } else {
            for(NestedInteger sub : element.getList()){
                dfs(sub, res);
            }
        }
    }
}
