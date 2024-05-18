class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        
        do {
            slow = sumOfSquares(slow);       // Move slow pointer one step
            fast = sumOfSquares(sumOfSquares(fast));  // Move fast pointer two steps
        } while (slow != fast);  // Detect cycle
        
        return slow == 1;  // If cycle ends at 1, then n is happy
    }
    
    private int sumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
}