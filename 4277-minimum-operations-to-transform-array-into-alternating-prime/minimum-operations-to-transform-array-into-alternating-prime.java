class Solution {
    public boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false; 
        }
        return true;
    }
    public int nextPrime(int num) {
        while (!isPrime(num)) {
            num += 1;
        }
        return num;
    } 
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ops = 0;
        
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                if (!isPrime(nums[i])) {
                    ops += nextPrime(nums[i] + 1) - nums[i];
                }
            }
            else {
                if (isPrime(nums[i])) {
                    if (nums[i] == 2) ops += 2;
                    else ops += 1;
                }
            }
        }
        return ops;
    }
}