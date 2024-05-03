class Solution {
    public int divisorSubstrings(int num, int k) {
        String numStr = String.valueOf(num);
        int count = 0;
        
        for (int i = 0; i <= numStr.length() - k; i++) {
            String substring = numStr.substring(i, i + k);
            int subNum = Integer.parseInt(substring);
            if (subNum != 0 && num % subNum == 0) {
                count++;
            }
        }
        
        return count;
    }
}