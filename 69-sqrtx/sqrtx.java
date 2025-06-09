class Solution {
    public int mySqrt(int x) {
    if (x == 0 || x == 1) return x;
      long sqrt = 1;
      for (long i = 2; i <= x / i; i++) {
        sqrt = i;
      }
      return (int)sqrt;
    }
}
