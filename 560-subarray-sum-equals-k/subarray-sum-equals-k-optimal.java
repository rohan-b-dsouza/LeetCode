// Optimal Solution =>

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap <Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        int preSum = 0;
        map.put(0, 1); // handling edge case
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int remove = preSum - k;
            cnt += map.getOrDefault(remove, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }
}

// T.C => O(n)
// S.C => O(n)
