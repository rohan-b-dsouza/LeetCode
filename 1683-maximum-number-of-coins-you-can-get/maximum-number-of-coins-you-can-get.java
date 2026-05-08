class Solution {
    public int maxCoins(int[] piles) {
        int n = piles.length;
        int k = n / 3;
        int ans = 0;
        Arrays.sort(piles);
        for (int i = n - 2; i >= 0 && k != 0; i -= 2) {
            ans += piles[i];
            k--;
        }
        return ans;
    }
}