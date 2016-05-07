/* http://www.lintcode.com/en/problem/clone-graph/  */


/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here

        // BFS original graph and using a Map to mimic the behavior.

        if(node == null) return null;
        // Map to maintain original ---> current relationship
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        // Start with the given node
        UndirectedGraphNode start = new UndirectedGraphNode(node.label);
        map.put(node, start);
        Queue<UndirectedGraphNode> myQ = new LinkedList<UndirectedGraphNode>();
        myQ.offer(node);

        while(! myQ.isEmpty()) {
            UndirectedGraphNode curNode = myQ.poll();
            for(UndirectedGraphNode next : curNode.neighbors) {
                if(!map.containsKey(next)) {
                    myQ.offer(next);
                    UndirectedGraphNode nextCp = new UndirectedGraphNode(next.label);
                    map.put(next, nextCp);
                }
                // Copy the adj info
                map.get(curNode).neighbors.add(map.get(next));
            }

        }
        return start;

    }
}
