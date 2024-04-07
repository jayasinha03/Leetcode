class Solution {
    public int numTrees(int n) {
        if (n <= 0) {
            return 0;
        }

        // Create an array to store the number of unique BSTs for each number of nodes.
        int[] dp = new int[n + 1];
        dp[0] = 1; // Empty tree

        // Calculate the number of unique BSTs for each number of nodes from 1 to n.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // For each root j, the number of unique BSTs is the product of
                // the number of unique BSTs in its left subtree and right subtree.
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }
}