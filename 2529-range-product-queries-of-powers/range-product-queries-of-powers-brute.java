// Brute 

class Solution {
    private static final int MOD = 1_000_000_007;
    public int calcPow(int left, int right, List<Integer> powers) {
        long power = 1;
        for (int i = left; i <= right; i++) {
            power = (power * powers.get(i)) % MOD;;
        }
        return (int) power;
    }
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> powers = new ArrayList<>();
        int[] ans = new int[size];
        while (n > 0) {
            int rightmostSetBit = n & -n;
            powers.add(rightmostSetBit);
            n = n & (n - 1);
        }
        int i = 0;
        for (int[] query : queries) {
            int power = calcPow(query[0], query[1], powers);
            ans[i++] = power;
        }
        return ans;
    }
}

// T.C => O(no. of set bits in n) + O(m * (right - left + 1)) where m is size of query array
// S.C => O(no. of powers) + O(m) where m is size of query array (ans array will always be of size m as mentioned in qn)
