class Solution {
    public int countVowelPermutation(int n) {
        if (n == 1) {
            return 5;
        }

        long a = 1, e = 1, i = 1, o = 1, u = 1;
        long mod = 1000000007L;

        for (int step = 2; step <= n; step++) {
            long newA = (e + u + i) % mod;
            long newE = (a + i) % mod;
            long newI = (e + o) % mod;
            long newO = i;
            long newU = (i + o) % mod;

            a = newA;
            e = newE;
            i = newI;
            o = newO;
            u = newU;
        }

        return (int)((a + e + i + o + u) % mod);        
    }
}