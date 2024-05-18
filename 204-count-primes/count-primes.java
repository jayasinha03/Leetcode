class Solution {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;  // There are no prime numbers less than 2
        }
        
        boolean[] isPrime = new boolean[n];
        // Initially, assume all numbers are prime
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        
        // Mark non-prime numbers
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // Count primes
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        
        return count;
    }
}