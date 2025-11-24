class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        long sum = 1L * n * (n + 1) / 2;
        int[] res = new int[n];
        int st = 0;
        int en = n - 1; 
        if ((((sum + target) % 2) != 0) || (Math.abs(target) > sum)) return new int[0];
        for (int i = n; i >= 1; i--) {
            if ((target + i) <= (1L * i * (i - 1)) / 2) {
                target += i;
                res[st++] = -i;
            }
            else {
                target -= i;
                res[en--] = i;
            }
        }
        return res;
    }
}