// Optimal 

class Solution {
    public int mySqrt(int x) {
    if (x == 0 || x == 1) return x;
      long low = 1;
      long high = x; 
      long sqrt = 1;
      while (low <= high) {
        long mid = low + (high - low) / 2;
        if (mid == x / mid) return (int) mid;
        if (mid < x / mid) {
            sqrt = mid;
            low = mid + 1;
        }
        else {
            high = mid - 1;
        }
      }
      return (int)sqrt; 
    }
}

// T.C => O(log (n))
// S.C => O(1)
