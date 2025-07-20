class Solution {
    public boolean isPrime(int n) {
    if (n <= 1) return false;
    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0) return false;
    }
    return true;
}

    public long splitArray(int[] nums) {
        if (nums.length == 0) return 0;
        long sumA = 0;
        long sumB = 0;
        for (int i = 0; i < nums.length; i++) {
            if (isPrime(i)) {
                sumA += nums[i];
            }
            else {
                sumB += nums[i];
            }
        }
        return Math.abs(sumA - sumB);
    }
}