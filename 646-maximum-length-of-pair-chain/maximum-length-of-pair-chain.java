class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        int maxChainLen = 0;
        int lastChainEndPos = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (pairs[i][0] > lastChainEndPos) {
                lastChainEndPos = pairs[i][1];
                maxChainLen++;
            }
        }
        return maxChainLen;
    }
}