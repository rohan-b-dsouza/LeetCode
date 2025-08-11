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

// T.C => O(no. of set bits in n) + O(m * (right - left + 1)) where m is size of query array
// S.C => O(no. of powers) + O(m) where m is size of query array (ans array will always be of size m as mentioned in qn)
