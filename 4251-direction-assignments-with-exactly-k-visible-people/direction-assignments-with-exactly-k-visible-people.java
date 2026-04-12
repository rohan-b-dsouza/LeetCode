class Solution {
    public long inverseMod(long base, long exp, long MOD) {
        long ans = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                exp = exp - 1;
                ans = (ans * base) % MOD;
            }
            else {
                exp >>= 1;
                base = (base * base) % MOD;
            }
        }
        return ans;
    }

    public long combination(long n, long k) {
        int MOD = 1000000007;
        long combs = 1;
        for (int i = 0; i < k; i++) {
            combs = (((combs * (n - i)) % MOD) * inverseMod(i + 1, MOD - 2, MOD)) % MOD;
        }
        return combs;
    }

    public int countVisiblePeople(int n, int pos, int k) {
        int MOD = 1000000007;
        return (int) ((2 * combination(n - 1, k)) % MOD);
    }
}

// ans is 2 * n-1 C k