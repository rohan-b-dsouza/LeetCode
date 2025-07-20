// Optimal

class Solution {
    public int specialTriplets(int[] nums) {
        HashMap<Integer, Integer> leftFreq = new HashMap<>();
        HashMap<Integer, Integer> rightFreq = new HashMap<>();
        int n = nums.length;
        int mod = 1000000007;
        for (int i = 0; i < n; i++) {
            rightFreq.put(nums[i], rightFreq.getOrDefault(nums[i], 0) + 1);
        }
        long cnt = 0;
        for (int j = 0; j < n; j++) {
            int mid = nums[j];
            rightFreq.put(mid, rightFreq.get(mid) - 1);
            int left = leftFreq.getOrDefault(2 * mid, 0);
            int right = rightFreq.getOrDefault(2 * mid, 0);
            cnt +=  (long) left * right;
            leftFreq.put(mid, leftFreq.getOrDefault(mid, 0) + 1);
        }
        return (int) (cnt % mod);
    }

}

// T.C => O(n) + O(n) = O(n) 
// S.C => O(2 * n) => O(n) ----------{for two hashmaps used}