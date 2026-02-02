class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        int MOD = 1000000007;
        long[] prefixSum = new long[n];
        long sum = 0;
        for (int i = 0; i < n ;i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }
        long ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                int nse = i;
                int idx = stack.pop();
                int pse = stack.isEmpty() ? -1 : stack.peek();
                int left = pse + 1;
                int right = nse - 1;
                if (left == 0) {
                    ans = Math.max(nums[idx] * 1L * prefixSum[right], ans);
                }
                else {
                    ans = Math.max(nums[idx] * 1L * (prefixSum[right] - prefixSum[left - 1]), ans);
                }
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int idx = stack.pop();
            int nse = n;
            int pse = stack.isEmpty() ? -1 : stack.peek();
            int left = pse + 1;
                int right = nse - 1;
                if (left == 0) {
                    ans = Math.max(nums[idx] * 1L * prefixSum[right], ans);
                }
                else {
                    ans = Math.max(nums[idx] * 1L * (prefixSum[right] - prefixSum[left - 1]), ans);
                } 
        }
        return (int) (ans % MOD);
    }
}