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

// Time Complexity

// Building powers list:
// n can have at most log₂(n) set bits.
// Extracting each set bit → O(log n)

// Answering each query:
// For a query [left, right], you iterate from left to right.
// Worst-case length = O(log n) (since powers.size() ≤ log₂(n)), and you do this for m queries.
// Total = O(m · log n)

// Overall:
// O(log n + m · log n) → O(m · log n) (since m can be large)

// Space Complexity

// powers list: at most log₂(n) elements → O(log n)

// Answer array: size = m → O(m)

// Other variables: O(1)

// Overall:
// O(log n + m)


