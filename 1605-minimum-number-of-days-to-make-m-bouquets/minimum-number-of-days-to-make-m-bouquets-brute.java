// Brute 

class Solution {
    public boolean bouquetsPossible(int[] bloomDay, int day, int k, int m) {
        int cnt = 0;
        int noofBouquets = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                cnt++;
            } else {
                noofBouquets += cnt / k;
                cnt = 0;
            }
        }
        noofBouquets += cnt / k;
        return noofBouquets >= m;

    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (k * m > n)
            return -1;
        int max = Integer.MIN_VALUE; int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, bloomDay[i]);
            min = Math.min(min, bloomDay[i]);
        }
        for (int i = min; i <= max; i++) {
            if (bouquetsPossible(bloomDay, i, k, m)) {
                return i;
            }
        }
        return -1;
    }
}

// T.C => O((max - min + 1) * n) where n is size of array
// S.C => O(1)
