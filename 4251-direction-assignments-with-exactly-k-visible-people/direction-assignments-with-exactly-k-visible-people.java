class Solution {
    int MOD = 1000000007;

    long power(long a, long b) {
        long res = 1;
        a %= MOD;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }

    long modInverse(long x) {
        return power(x, MOD - 2);
    }

    public long combination(long n, long k) {
        long combs = 1;
        for (int i = 0; i < k; i++) {
            combs = (combs * (n - i)) % MOD;
            combs = (combs * modInverse(i + 1)) % MOD;
        }
        return combs;
    }

    public int countVisiblePeople(int n, int pos, int k) {
        return (int) ((2 * combination(n - 1, k)) % MOD);
    }
}

// ans is 2 * n-1 C k