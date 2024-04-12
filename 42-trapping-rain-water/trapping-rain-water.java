class Solution {
    public int trap(int[] height) {
         int n = height.length;
        if (n == 0) return 0;
        
        int[] leftMax = new int[n]; // to store the max height to the left of each index
        int[] rightMax = new int[n]; // to store the max height to the right of each index
        
        // Compute the left max height for each index
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        
        // Compute the right max height for each index
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        
        // Calculate the trapped water for each index
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            trappedWater += minHeight - height[i];
        }
        
        return trappedWater;
    }
}