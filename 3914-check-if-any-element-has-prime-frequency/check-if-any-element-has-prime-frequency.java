class Solution {
    public boolean isPrime(int n) {
        if (n == 1)
            return false;
        boolean flag = false;
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                flag = true;
                break;
            }
        }
        if (!flag)
            return true;
        return false;
    }

    public boolean checkPrimeFrequency(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (isPrime(entry.getValue()))
                return true;
        }
        return false;
    }
}