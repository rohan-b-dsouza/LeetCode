class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;
        int n = arr.length;

        Deque<Integer> stack = new ArrayDeque<>();
        long sum = 0;

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? Integer.MIN_VALUE : arr[i];

            while (!stack.isEmpty() && arr[stack.peek()] > curr) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;

                long leftCount = mid - left;
                long rightCount = right - mid;

                long contribution = (arr[mid] * leftCount % MOD) * rightCount % MOD;
                sum = (sum + contribution) % MOD;
            }

            stack.push(i);
        }

        return (int) sum;
    }
}
