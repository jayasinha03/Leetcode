class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;  // The first ugly number is 1
        
        int i2 = 0, i3 = 0, i5 = 0;  // Indices for multiples of 2, 3, and 5
        int next2 = 2, next3 = 3, next5 = 5;  // Initial multiples of 2, 3, and 5
        
        for (int i = 1; i < n; i++) {
            int nextUgly = Math.min(next2, Math.min(next3, next5));
            dp[i] = nextUgly;
            
            if (nextUgly == next2) {
                i2++;
                next2 = dp[i2] * 2;
            }
            if (nextUgly == next3) {
                i3++;
                next3 = dp[i3] * 3;
            }
            if (nextUgly == next5) {
                i5++;
                next5 = dp[i5] * 5;
            }
        }
        
        return dp[n - 1];
    }
}