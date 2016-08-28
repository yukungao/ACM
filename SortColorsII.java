/* http://www.lintcode.com/en/problem/sort-colors-ii/# */
// At first, I do the full quick sort, which is not necessary
// Every time, store the min/max and sort based on value == min or value == max


class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here

        if(colors == null || colors.length < 2) return;

        // Everytime make sure the min-color is at left-most and max-color is at
        // right-most

        //Use count to store already sorted color
        int start = 0;
        int end = colors.length - 1;
        int count = 0;

        while(count < k) {
            // Find the min/max value
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for(int i = start; i <= end; i++) {
                min = Math.min(colors[i], min);
                max = Math.max(colors[i], max);
            }

            // 3-way partition
            int left = start;
            int right = end;
            int i = left;

            while( i <= right ){
                if(colors[i] == min) {
                    swap(colors, i++, left++);
                } else if(colors[i] == max) {
                    swap(colors, i, right--);
                } else {
                    i++;
                }
            }

            start = left;
            end = right;
            count += 2;
        }
        return;
    }

    private void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }


}
