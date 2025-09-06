// Optimal (Greedy) (Same as the problem N meetings in one room)

class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        // Sort pairs with respect to end pos in ascending order
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        // Set maxlen to 0 initially
        int maxChainLen = 0;
        // Set lastChainEndPos to minimum value initially
        int lastChainEndPos = Integer.MIN_VALUE;
        // Select pairs greedily
        for (int i = 0; i < n; i++) {
            // if current pair start is greater than last pair end select this pair
            if (pairs[i][0] > lastChainEndPos) {
                // update last chain end to current chain's end
                lastChainEndPos = pairs[i][1];
                // Increment chain length by 1
                maxChainLen++;
            }
        }
        return maxChainLen;
    }
}


// T.C => O(n * log(n)) + O(n) = O(n * log (n))
// S.C => O(1)
