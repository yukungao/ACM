/* Two Swap */
public int trap(int[] height) {
        /*
        For the given position, the water is can trap
        is the max(0, min(maxLeft, maxRight) - currPosition)
        Where the maxLeft, is the number it could find from left-to-right
        maxRight is it could from right-to-left;
        */

        /* Sanity Check */
        if(height == null || height.length <= 2) return 0;

        int[] leftmax = new int[height.length];
        int[] rightmax = new int[height.length];

        int leftsofar = 0;
        // From the left to right
        for(int i = 0; i < height.length; i++) {
            leftmax[i] = leftsofar;
            leftsofar = Math.max(leftsofar, height[i]);
        }


        //From the right to left
        int rightsofar = 0;
        for(int i = height.length - 1; i >= 0; i--) {
            rightmax = rightsofar;
            rightsofar = Math.max(rightsofar, height[i]);
        }

        // Caculate the result:
        int res = 0;
        for(int i = 0; i < height.length; i++) {
            res += Math.max(0, (Math.min(leftmax[i], rightmax[i]) - height[i]));
        }

        return res;

    }
