class Solution {
    public int distinctSubseqII(String s) {
        int mod = (int) 1e9 + 7;
        int n = s.length();
        int[] record4DeDup = new int[26];
        int curRes = 1;//empty
        char[] chs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int addCount = curRes;
            curRes = ((curRes + addCount) % mod - record4DeDup[chs[i] - 'a'] % mod + mod) % mod;
            record4DeDup[chs[i] - 'a'] = addCount;
        }
        return (curRes - 1 + mod) % mod;
    }
}