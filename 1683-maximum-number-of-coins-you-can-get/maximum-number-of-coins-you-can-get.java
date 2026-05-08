class Solution {
    public int maxCoins(int[] piles) {
        int n = piles.length;
        int k = n / 3;
        int ans = 0;
        Arrays.sort(piles);
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int temp = piles[i];
            piles[i] = piles[j];
            piles[j] = temp;
        }
        for (int i = 1; i < n && k != 0; i += 2) {
            ans += piles[i];
            k--;
        }
        return ans;
    }
}