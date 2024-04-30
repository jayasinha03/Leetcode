class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;

        // Initialize the DP array with the values of the first row
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = grid[0][j];
        }

        // Iterate from the second row to the last row
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Initialize the minimum falling path sum for the current cell
                dp[i][j] = Integer.MAX_VALUE;

                // Find the minimum falling path sum considering non-zero shifts
                for (int k = 0; k < n; k++) {
                    if (j != k) {
                        dp[i][j] = Math.min(dp[i][j], grid[i][j] + dp[i - 1][k]);
                    }
                }
            }
        }

        // Find the minimum falling path sum in the last row
        int minFallingPathSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minFallingPathSum = Math.min(minFallingPathSum, dp[n - 1][j]);
        }

        return minFallingPathSum;
    }
}