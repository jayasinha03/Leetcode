class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        
        // If lengths of s1 and s2 don't match the length of s3, then s3 can't be interleaved.
        if (m + n != s3.length()) {
            return false;
        }
        
        // dp[i][j] represents whether s3[0...(i+j-1)] is formed by the interleaving of 
        // s1[0...i-1] and s2[0...j-1].
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Base case: an empty string can be formed by interleaving two empty strings.
        dp[0][0] = true;
        
        // Fill the first column. s1 is empty.
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        
        // Fill the first row. s2 is empty.
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        
        // Fill the rest of the dp array using dynamic programming.
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                           (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        
        // Return whether s3 can be formed by interleaving s1 and s2.
        return dp[m][n];
    }
}