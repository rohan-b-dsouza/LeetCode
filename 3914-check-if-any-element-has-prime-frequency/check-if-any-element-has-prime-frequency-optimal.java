// Optimal

class Solution {
    public boolean isPrime(int n) {
        if (n == 1)
            return false;
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean checkPrimeFrequency(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int freq : map.values()) {
            if (isPrime(freq)) return true;
        }
        return false;
    }
}

// T.C => O(n * sqrt(n)) 
// S.C => O(N) where N is no. of distinct elements in the input array
