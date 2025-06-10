
// Optimal

class Solution {

    public int sumofhours(int[] piles, int mid, int h) {
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += (int) Math.ceil((double) piles[i] / mid);
            if (sum > h)
                return -1;
        }
        return 1;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, piles[i]);
        }
        int low = 1;
        int high = max;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sumofhours(piles, mid, h) == 1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

// T.C => O(log(max) * n) where max is maximum element in piles array and n is size of piles array
// S.C => O(1)
