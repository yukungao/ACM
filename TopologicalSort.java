/* http://www.lintcode.com/en/problem/topological-sorting/ */
/*
DFS Version:
Push current node only if its sub has finished dfs. This satisfy the definition
*/
public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
    // write your code here
    // DFS version, put the node into the stack, only after all its
    // subNode has been visited.
    if(graph == null || graph.size() == 0) return null;

    Stack<DirectedGraphNode> stack = new Stack<DirectedGraphNode>();
    HashMap<DirectedGraphNode, Boolean> map = new HashMap<DirectedGraphNode, Boolean>();

    for(DirectedGraphNode node : graph) {
        map.put(node, false);
    }

    for(DirectedGraphNode root : graph) {
        if(map.get(root) == false) {
            dfs(map, stack, root);
        }
    }

    ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();

    while(!stack.isEmpty()) {
        res.add(stack.pop());
    }

    return res;
}


private void dfs(HashMap<DirectedGraphNode, Boolean> map,Stack<DirectedGraphNode> stack, DirectedGraphNode currNode) {
    map.put(currNode, true);

    for(DirectedGraphNode neighbor : currNode.neighbors){
        if(map.get(neighbor) == false) {
            dfs(map,stack,neighbor);
        }
    }

    stack.push(currNode);
}

/*
  BFS Version
*/
/*
1. Put whatever 0 indegrees in the queue first
2. Don't need to use visited to compute
*/

public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
     // write your code here
     if(graph == null || graph.size() == 0) return null;

     // Step 1: calculate the in-gree for every Node and store it in a hash map
     HashMap<DirectedGraphNode, Integer> indegrees = new HashMap<DirectedGraphNode, Integer>();

     // Compute the indegrees of node
     for(DirectedGraphNode node : graph) {
         for(DirectedGraphNode neighbor : node.neighbors) {
             if(!indegrees.containsKey(neighbor)) {
                 indegrees.put(neighbor, 1);
             } else {
                 indegrees.put(neighbor, indegrees.get(neighbor) + 1);
             }
         }
     }
     // Put whatever indegress is 0 into the queue;
     Queue<DirectedGraphNode> myQueue = new  LinkedList<DirectedGraphNode>();
     ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();

     for(DirectedGraphNode node : graph) {
         // If it doesn't in the indegrees, means it
         // has 0 indegree
         if(!indegrees.containsKey(node)) {
             myQueue.offer(node);
         }
     }

     while(!myQueue.isEmpty()) {
         DirectedGraphNode curr = myQueue.poll();
         res.add(curr);

         // Inspect Nighbor and put whose indegree is 0 into Queue
         for(DirectedGraphNode neighbor : curr.neighbors) {
             indegrees.put(neighbor, indegrees.get(neighbor) -1 );
             if(indegrees.get(neighbor) == 0) {
                 myQueue.offer(neighbor);
             }
         }
     }

     return res;
 }
