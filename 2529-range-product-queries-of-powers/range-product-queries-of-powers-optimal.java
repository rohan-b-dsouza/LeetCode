// Optimized (Pre-requisite :- Inverse Modulo and Fermat's Little Theorem)

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
        // List to store the powers
        List<Integer> powers = new ArrayList<>();
        // Call the function to find powers
        findPowers(n, powers);

        // Build a prefix Prod Array, for optimizing query processing which was lacking in the brute force method
        long[] prefixProd = new long[powers.size() + 1];
        prefixProd[0] = 1;
        for (int i = 0; i < powers.size(); i++) {
            prefixProd[i + 1] = (prefixProd[i] * powers.get(i)) % MOD;
        }
        // Array to store the answer
        int[] ans = new int[queries.length];
        // Process each query and store the answer in 'ans' array
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            // Use Inverse Modulo to do ((x / y) % MOD) as Normal Integer Division can't be done as according to modulo mathematics -> (a / b) % MOD = (a * b^-1) % MOD) ---> And further applying fermat's little theorem we get => (a * b^(M-2)) % MOD
            // Thus, due to MOD we have to multiply x with MODULO INVERSE OF y
            // In our problem x is prefixProd[right + 1] and y is prefixProd[left] 
            ans[i] = (int) ((prefixProd[right + 1] * modPow(prefixProd[left], MOD - 2)) % MOD);
        }
        return ans;
    }
}

// Time Complexity (TC):

// - Extracting powers of two from n:
//   Runs in O(k), where k = number of set bits in n.

// - Building prefix product array:
//   Iterates over k powers → O(k) 

// - Answering queries:
//   Each query requires modular inverse calculation using fast exponentiation.
//   Modular exponentiation takes O(log MOD) time, where MOD = 10^9 + 7 (~30 operations).
//   For q queries, total = O(q * log MOD) ≈ O(q).

// Overall Time Complexity:
// O(q)


// Space Complexity (SC):

// - Powers list: stores up to k elements (set bits) → O(k) 
// - Prefix product array: size k + 1 → O(k)
// - Result array for queries: size q → O(q).

// Overall Space Complexity:
// O(q)



