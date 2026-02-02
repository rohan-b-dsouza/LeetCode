class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num);
        }
        int max = 0;
        for (int num : st) {
            if (!st.contains(num + 1)) {
                int cnt = 1;
                int x = num - 1;
                while(st.contains(x--)) {
                    cnt++;
                }
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}