class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;  // Ugly numbers must be positive
        }
        
        // Continuously divide n by 2, 3, and 5
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        
        // If the final value of n is 1, it is an ugly number
        return n == 1;
    }
}