class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 ) {
        return false; 
    }
        int value = x;
        int rem;
        int reverse = 0;
        while(value>0){
            rem = value % 10;
            reverse = (reverse * 10) + rem;
            value/=10;
        }
        return x == reverse;
    }
}