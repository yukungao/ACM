/* http://www.lintcode.com/en/problem/search-a-2d-matrix/ */
/* Search 2D matrix */
/* The easy implementation way is to find the row first, then column
Please be careful we should use matrix[x_end][0] <= target first instead of
matrix[x_start][0] <= target.
*/


public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return false;

        int x_start = 0;
        int x_end = matrix.length-1;

        int row = x_start;

        //Search Method, first to find x
        while(x_start + 1 < x_end) {
            int x_mid = x_start + (x_end - x_start)/2;


            if(matrix[x_mid][0] == target) return true;
            else if(matrix[x_mid][0] < target) x_start = x_mid;
            else x_end = x_mid;
        }

        if(matrix[x_end][0] <= target) {
            row = x_end;
        } else if(matrix[x_start][0] <= target) {
            row = x_start;
        } else {
            return false;
        }

        int y_start = 0;
        int y_end = matrix[0].length-1;
        while(y_start + 1 < y_end) {
            int y_mid = y_start + (y_end - y_start)/2;

            if(matrix[row][y_mid] == target) return true;
            else if(matrix[row][y_mid] < target) y_start = y_mid;
            else y_end = y_mid;
        }
        return (matrix[row][y_start] == target) || (matrix[row][y_end] == target);
    }
}
