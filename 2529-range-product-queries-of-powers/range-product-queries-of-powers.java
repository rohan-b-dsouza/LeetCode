import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    // Fast modular exponentiation
    private long modPow(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if (exp % 2 == 1) {
                exp--;
                result = (result * base) % MOD;
            } else {
                exp /= 2;
                base = (base * base) % MOD;
            }
        }
        return result;
    }

    public void findPowers(int n, List<Integer> powers) {
        while (n > 0) {
            int rightmostSetBit = n & -n;
            powers.add(rightmostSetBit);
            n = n & (n - 1);
        }
    }

    public int[] productQueries(int n, int[][] queries) {
        List<Integer> powers = new ArrayList<>();
        findPowers(n, powers);

        // Prefix product array
        long[] prefixProd = new long[powers.size() + 1];
        prefixProd[0] = 1;
        for (int i = 0; i < powers.size(); i++) {
            prefixProd[i + 1] = (prefixProd[i] * powers.get(i)) % MOD;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            ans[i] = (int) ((prefixProd[right + 1] * modPow(prefixProd[left], MOD - 2)) % MOD);
        }
        return ans;
    }
}
