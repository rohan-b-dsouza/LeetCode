class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[n];
        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;
            while (!stack.isEmpty() && nums[idx] >= stack.peek()) {
                stack.pop();
            }
            if (i < n) {
                if (stack.isEmpty()) ans[i] = -1;
                else ans[i] = stack.peek();
            }
            stack.push(nums[idx]);
        } 
        return ans;
    }
}
