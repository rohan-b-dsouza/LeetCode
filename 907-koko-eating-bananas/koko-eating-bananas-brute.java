// Brute 

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, piles[i]);
        }
        for (int i = 1; i <= max; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += (int) Math.ceil((double) piles[j] / i);
                if (sum > h)
                    break;
            }
            if (sum <= h)
                return i;
        }
        return -1;
    }
}

// T.C => O(max * n)
// S.C => O(1)
