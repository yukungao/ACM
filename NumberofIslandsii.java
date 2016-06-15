/* http://www.lintcode.com/en/problem/number-of-islands-ii/ */
/* Number of island-ii */
/* Union-found */
* class Point {
*     int x;
*     int y;
*     Point() { x = 0; y = 0; }
*     Point(int a, int b) { x = a; y = b; }
* }
*/
public class Solution {
   /**
    * @param n an integer
    * @param m an integer
    * @param operators an array of point
    * @return an integer array
    */
   public List<Integer> numIslands2(int n, int m, Point[] operators) {

       List<Integer> res = new ArrayList<Integer>();

       if(operators == null || operators.length == 0) return res;


       // Write your code here
       QuickUnion union = new QuickUnion(n,m);

       int[] dx = {1,0,-1,0};
       int[] dy = {0,1,0,-1};

       //Iterate through the operators and
       for(Point element : operators) {
               int x = element.x;
               int y = element.y;

               // Take x,y as a new Island first
               union.addIsland(x,y);

               // Four direction, union, this could decrease the # of island
               for(int i= 0; i < 4; i++) {
                   int newX = x + dx[i];
                   int newY = y + dy[i];
                   // Continue if out of boundary
                   if(newX < 0 || newY < 0 || newX >= n || newY >= m ) continue;

                   // They are not
                   if(union.getSize(newX, newY) == 0) continue;
                   union.unite(x, y, newX, newY);
               }
               res.add(union.island);
       }

       return res;

   }
}


class QuickUnion {
       private int[] id;
       private int[] size;
       int m,n;
       int island;

       public QuickUnion(int m, int n) {
           this.m = m;
           this.n = n;
           id = new int[m * n];
           size = new int[m * n];
           island = 0;
       }

       //Get the root for index i (root is the representative)
       private int root(int i) {
           while (i != id[i]) {
               id[i] = id[id[i]];  //Path compression
               i = id[i];
           }
           return i;
       }

       //Get the component size, if the size is 0 then we don't have an island yet.
       public int getSize(int x, int y) {
           return size[getIndex(x, y)];
       }

       private int getIndex(int x, int y) {
           return x * n + y;
       }

       public void addIsland(int x, int y) {
           int p = getIndex(x, y);
           if (size[p] != 0) return;
           size[p] = 1;
           id[p] = p;
           island++;
       }

       public void unite(int x1, int y1, int x2, int y2) {
           unite(getIndex(x1, y1), getIndex(x2, y2));
       }

       private void unite(int p, int q) {
           int i = root(p);
           int j = root(q);
           if (i != j) island--;  //If we are merging two different islands, then island count decreases.
           if (size[i] < size[j]) {
               id[i] = j;
               size[j] += size[i];
           }
           else {
               id[j] = i;
               size[i] += size[j];
           }
       }
   }
