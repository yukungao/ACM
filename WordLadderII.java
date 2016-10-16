/* http://www.lintcode.com/en/problem/word-ladder-ii/ */

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        List<List<String>> res = new ArrayList<List<String>>();
        if(dict.size() == 0) return res;

        Map<String, List<String>> graph = new HashMap<String, List<String>>();
        Map<String, Integer> distance = new HashMap<String, Integer>();

        // BFS
        Queue<String> myQ = new LinkedList<String>();
        myQ.offer(start);
        distance.put(start, 0);
        // Initialize the map
        for(String str : dict) {
            graph.put(str, new ArrayList<String>());
        }

        while ( !myQ.isEmpty()) {

            String curNode = myQ.poll();

            for(char c = 'a'; c <= 'z'; c++) {
                for(int j = 0; j < curNode.length(); j++) {
                    if(c == curNode.charAt(j)) continue;
                    String tmp = replace(curNode, c, j);

                    if(dict.contains(tmp)) {
                        // Store the pre Node;
                        graph.get(tmp).add(curNode);
                        //
                        if(!distance.containsKey(tmp)) {
                            distance.put(tmp, distance.get(curNode) + 1);
                            myQ.offer(tmp);
                        }
                    }

                }
            }
        }

        //DFS to do the backtracking
        List<String> path = new ArrayList<String>();
        dfs(res, path, end, start, distance, graph);
        return res;
    }

    private String replace(String str, char c, int j) {
        char [] chars = str.toCharArray();
        chars[j] = c;
        return new String(chars);
    }

    private void dfs(List<List<String>> res, List<String> path, String curNode, String start,
                    Map<String, Integer> distance, Map<String, List<String>> graph) {

        // Add curNode and then do the recursion
        path.add(curNode);

        if(curNode.equals(start)){
            // Need to reverse, since its end--->start.
            Collections.reverse(path);
            res.add(new ArrayList<String>(path));
            // Reverse back for further usage
            Collections.reverse(path);
        } else {
            for(String next : graph.get(curNode)) {
                // Tell if its adj-nodes
                if(distance.containsKey(next) && distance.get(curNode) == distance.get(next) + 1) {
                    dfs(res, path, next, start, distance, graph);
                }
            }
        }
        // In order to get back to previous state
        path.remove(path.size() -1 );
    }
}





public class Solution {
   /**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return a list of lists of string
     */


   class node{
       node last;
       String str;

       public node(String str){
           this.last = null;
           this.str = str;
       }

       public node(node last, String str){
           this.last = last;
           this.str = str;
       }
   }

   public List<List<String>> findLadders(String start, String end, Set<String> dict) {
       // write your code here

       List<List<String>> res = new ArrayList<List<String>>();
       dict.remove(start);
       dict.add(end);

       Queue<node> curr = new LinkedList<node>();
       Queue<node> next = new LinkedList<node>();
       ArrayList<node> list = new ArrayList<node>();

       curr.offer(new node(start));

       while(!curr.isEmpty()){

           node temp = curr.poll();
           dict.remove(temp.str);

           char[] array = temp.str.toCharArray();

           for(int i = 0; i < array.length; i++){
               char origin = array[i];

               for(char c = 'a'; c <= 'z'; c++){
                   if(c == origin)
                       continue;

                   array[i] = c;
                   String next_str = String.valueOf(array);

                   if(next_str.equals(end)){
                       list.add(new node(temp, next_str));
                   }
                   else if(dict.contains(next_str)){
                       next.offer(new node(temp, next_str));
                   }
               }

               array[i] = origin;
           }

           if(curr.isEmpty()){
               if(list.size() > 0)
                   break;

               curr = next;
               next = new LinkedList<node>();
           }
       }

       for(int i = 0; i < list.size(); i++){
           node target = list.get(i);
           List<String> path = new ArrayList<String>();

           while(target.last != null){
               path.add(0, target.str);
               target = target.last;
           }
           path.add(0, target.str);

           res.add(path);
       }

       return res;
   }
}
