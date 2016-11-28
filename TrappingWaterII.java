public int trapRainWater(int[][] heightMap) {

    /*
    BFS to do the 2D search

    Let's think from the trapping water 1, we are trying to find the
    Math.min(leftmax, rightmax);
    However, right now we are going to find Math.min(leftmax,rightmax,upmax,downmax)
    Then we need a data structure to keep the order so that we get filled from leftmax instead of others
    Thus we are going to use priority queue.

    Another point is, we need to pass down the leftmax/rightmax/upmax/downmax, thus when adding nextstep to queue,
    we need to add newcell( Math.max(leftmax,currHeigth)) so that we can generate correct currHeight!

    */

    // Boundary condition check
    if(heightMap == null || heightMap.length == 0 || heightMap[0].length <= 2) return 0;

    PriorityQueue<Cell> pq = new PriorityQueue<Cell>(1, new Comparator<Cell>() {
        @Override
        public int compare(Cell a, Cell b) {
            return a.height - b.height;
        }
    });

    int x_size = heightMap.length;
    int y_size = heightMap[0].length;

    boolean[][] visited = new boolean[x_size][y_size];

    // Add the outlayers cell into pq
    for(int i = 0; i < x_size; i++) {
        Cell first = new Cell(i,0, heightMap[i][0]);
        Cell last = new Cell(i, y_size - 1, heightMap[i][y_size - 1]);
        pq.offer(first);
        pq.offer(last);
        visited[i][0] = true;
        visited[i][y_size - 1] = true;
    }

    for(int i = 0; i < y_size; i++) {
        Cell first = new Cell(0, i, heightMap[0][i]);
        Cell last = new Cell(x_size - 1,  i, heightMap[x_size-1][i]);
        pq.offer(first);
        pq.offer(last);
        visited[0][i] = true;
        visited[x_size - 1][i] = true;
    }


    int res = 0;

    // Do the BFS.
    /* up down left right */
    int [] dx = new int[]{1, -1, 0, 0};
    int [] dy = new int[]{0, 0, -1, 1};
    while(!pq.isEmpty()) {
        Cell curr = pq.poll();
        for(int i = 0; i < 4; i++) {
            int next_x = curr.x_index + dx[i];
            int next_y = curr.y_index + dy[i];
            if(next_x < 0 || next_x >= x_size || next_y < 0 || next_y >= y_size || visited[next_x][next_y]) continue;
            pq.offer(new Cell(next_x, next_y, Math.max(curr.height, heightMap[next_x][next_y])));
            visited[next_x][next_y] = true;
            res += Math.max(0, curr.height - heightMap[next_x][next_y]);
        }
    }

    return res;
}

public class Cell {
    public int x_index;
    public int y_index;
    public int height;

    public Cell(int x, int y, int h) {
        x_index = x;
        y_index = y;
        height = h;
    }
}
