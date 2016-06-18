/* http://www.lintcode.com/en/problem/search-a-2d-matrix-ii/ */

/* From top-right to bottom-left*/
public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
        return 0;
        // Search from top right to bottom left

        int res = 0;
        int row = 0;
        int col = matrix[0].length - 1;

        // The boundary of the
        while(row < matrix.length && col >= 0) {
            if(matrix[row][col] < target) {
                row++;
            } else if(matrix[row][col] > target) {
                col--;
            } else {
                res++;
                col--;
                row++;
            }
        }
        return res;
    }
}

/*From bottom-left to top-right*/
public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
        return 0;
        // Search from top right to bottom left

        int res = 0;
        int row = matrix.length-1;
        int col = 0;

        // The boundary of the
        while(row >= 0 && col < matrix[0].length) {
            if(matrix[row][col] < target) {
                col++;
            } else if(matrix[row][col] > target) {
                row--;
            } else {
                res++;
                col++;
                row--;
            }
        }
        return res;
    }
}
