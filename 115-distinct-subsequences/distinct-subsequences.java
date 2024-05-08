class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        // dp[i][j] represents the number of distinct subsequences of s[0...i-1] that equals t[0...j-1]
        int[][] dp = new int[m + 1][n + 1];
        
        // Initialize the first column with 1 since an empty string is a subsequence of any string
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        
        // Populate the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // If the characters match, we have two options:
                    // 1. Include both characters in the subsequence
                    // 2. Skip the current character of s and continue with the previous character
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // If the characters don't match, we can only skip the current character of s
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[m][n];
    }
}