/* http://www.lintcode.com/en/problem/route-between-two-nodes-in-graph/# */
/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */

/*
Basic DFS, no much too say. Only pay attetion that for every dfs()
follow the template:

dfs() {
  if() {
    return
  }

  for() {
    dfs();
    // If found one problem, need to return within the for loop.
  }
}

*/
public class Solution {
   /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph,
                            DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        Map<DirectedGraphNode, Boolean> visited = new HashMap<DirectedGraphNode, Boolean>();

        for(DirectedGraphNode node : graph) {
            visited.put(node, false);
        }

        return dfs(s, t, visited);


    }

    public boolean dfs( DirectedGraphNode currNode, DirectedGraphNode t, Map<DirectedGraphNode, Boolean> visited) {
        // Always put the return condition first

        if(currNode == t) {
            return true;
        }

        // Mark currNode as visited
        visited.put(currNode, true);

        for(DirectedGraphNode nextNode : currNode.neighbors) {
            if(visited.get(nextNode) == false) {
                if(dfs(nextNode, t, visited)) {
                    return true;
                }
            }
        }

        return false;

    }
}
