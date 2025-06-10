
// Optimal

class Solution {

    public boolean BouquetsPossible(int[] bloomDay, int day, int k, int m) {
    int cnt = 0;
    int noofBouquets = 0;
    for (int i = 0; i < bloomDay.length; i++) {
      if (bloomDay[i] <= day) {
        cnt++;
      }
      else {
        noofBouquets += cnt / k;
        cnt = 0;
      }
    }
    noofBouquets += cnt / k;
    return noofBouquets >= m;
  }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long) k * m > n)
            return -1;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            high = Math.max(high, bloomDay[i]);
            low = Math.min(low, bloomDay[i]);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (BouquetsPossible(bloomDay, mid, k, m)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

// T.C => O(log(max - min + 1) * n) where n is size of array
// S.C => O(1)
