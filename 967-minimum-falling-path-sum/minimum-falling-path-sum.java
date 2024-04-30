class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        // Initialize the DP array with the values of the last row
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = matrix[n - 1][j];
        }

        // Iterate from the second last row to the first row
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                // Compute the minimum falling path sum for the current cell
                int minPathSum = dp[i + 1][j];
                if (j > 0) {
                    minPathSum = Math.min(minPathSum, dp[i + 1][j - 1]);
                }
                if (j < n - 1) {
                    minPathSum = Math.min(minPathSum, dp[i + 1][j + 1]);
                }
                dp[i][j] = matrix[i][j] + minPathSum;
            }
        }

        // Find the minimum falling path sum in the first row
        int minFallingPathSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            minFallingPathSum = Math.min(minFallingPathSum, dp[0][j]);
        }

        return minFallingPathSum;
    }
}