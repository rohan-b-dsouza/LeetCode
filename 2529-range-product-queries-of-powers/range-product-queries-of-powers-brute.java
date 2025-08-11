// Brute 

class Solution {
    // Storing modulo 10^9 + 7
    private static final int MOD = 1_000_000_007;
    // Calculating product of powers list from left to right
    public int calcPow(int left, int right, List<Integer> powers) {
        long power = 1;
        for (int i = left; i <= right; i++) {
            power = (power * powers.get(i)) % MOD;;
        }
        return (int) power;
    }
    public int[] productQueries(int n, int[][] queries) {
        int size = queries.length;
        // List to store the powers
        List<Integer> powers = new ArrayList<>();
        // Array to store the answer of products
        int[] ans = new int[size];
        // Finding the powers
        while (n > 0) {
            // Find rightmost set bit of n, its also the power of 2 hence add to powers
            int rightmostSetBit = n & -n;
            powers.add(rightmostSetBit);
            // Remove the rightmost set bit to take the next power of 2 in next iteration
            n = n & (n - 1);
        }
        int i = 0;
        // For each query, compute the product of powers from left to right
        for (int[] query : queries) {
            int power = calcPow(query[0], query[1], powers);
            ans[i++] = power;
        }
        return ans;
    }
}

// Time Complexity (TC):

// - Extracting powers of two from n:
//   Runs in O(k), where k = number of set bits in n (≤ 30).

// - For each query:
//   calcPow runs from left to right indices, up to k iterations per query.

// - For q queries, worst-case time:
//   O(q * k)

// Since k ≤ 30, this can be up to 30 * q operations, which might be slow for large q.


// Space Complexity (SC):

// - Powers list stores k elements → O(k) ≈ O(1).
// - Result array stores q elements → O(q).
// - No extra significant space used.

// Overall space:
// O(q + k) ≈ O(q)




