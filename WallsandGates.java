/* https://leetcode.com/problems/walls-and-gates/ */
/*
典型bfs题目，因为bfs可以天然的保证最短路径(因为你这里的distance都是1么);

*/

public class Solution {
    public void wallsAndGates(int[][] rooms) {
        // No operation if no need to operate
        if(rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) {
            return;
        }

        // From the zero then do the bfs(in-place-modify)
        int x_size = rooms.length;
        int y_size = rooms[0].length;


        Queue<int[]> myQ = new LinkedList<int[]>();

        for(int i = 0; i < x_size; i++) {
            for(int j = 0; j < y_size; j++) {
                if(rooms[i][j] == 0) {
                    myQ.offer(new int[]{i,j});
                }
            }
        }
        // No need to use level to track
        // int level = 0;

        // Start the bfs
        while(!myQ.isEmpty()) {
            int[] curr_index = myQ.poll();
            int x_index = curr_index[0];
            int y_index = curr_index[1];

            // Out of bounary, continue directly


            // Check the surrounding area
            // If surroudning is INF, change the distance
            if(validIndex(x_index+1, y_index, x_size, y_size, rooms)) {
                rooms[x_index+1][y_index] = rooms[x_index][y_index] + 1;
                myQ.offer(new int[]{x_index+1, y_index});
            }

            if(validIndex(x_index-1, y_index, x_size, y_size, rooms)) {
                rooms[x_index-1][y_index] = rooms[x_index][y_index] + 1;
                myQ.offer(new int[]{x_index-1, y_index});
            }

            if(validIndex(x_index, y_index+1, x_size, y_size, rooms)) {
                rooms[x_index][y_index+1] = rooms[x_index][y_index] + 1;
                myQ.offer(new int[]{x_index, y_index+1});
            }

            if(validIndex(x_index, y_index-1, x_size, y_size, rooms)) {
                rooms[x_index][y_index-1] = rooms[x_index][y_index] + 1;
                myQ.offer(new int[]{x_index, y_index-1});
            }

        }

    }

    private boolean validIndex(int x_index, int y_index, int x_size, int y_size, int[][] rooms) {
           if(x_index >= 0 && x_index < x_size && y_index >= 0 && y_index < y_size && rooms[x_index][y_index] == Integer.MAX_VALUE) {
                return true;
            } else {
                return false;
            }
    }
}
