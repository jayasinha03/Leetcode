class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int m_sum = 0;
        int total = m+n;
        for(int i=0; i<m; i++){
            m_sum += rolls[i];
        }
        int n_sum = (mean*total) - m_sum;
        if(n > n_sum || n_sum > 6*n){
            return new int[0];
        }
        int[] result = new int[n];
        int val = n_sum/n;
        int rem = n_sum%n;
        for(int i=0; i<n; i++){
            result[i] = val + (i < rem ? 1 : 0);
        }
        return result;
    }
}