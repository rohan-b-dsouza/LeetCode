class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int maxSeq = 1;
        for (int num : set) {
            if (!set.contains(num + 1)) {
                int cnt = 1;
                int next = num - 1;
                while (set.contains(next)) {
                    cnt++;
                    next--;
                }
                maxSeq = Math.max(maxSeq, cnt);
            }
        }
        return maxSeq;
    }
}