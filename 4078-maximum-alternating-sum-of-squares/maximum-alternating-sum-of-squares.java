class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        long[] squares = new long[n];
        for (int k = 0; k < n; k++) {
            squares[k] = (long) nums[k] * nums[k];
        }
        Arrays.sort(squares);
        long sum = 0;
        while (i <= j) {
            if (i == j) {
                sum += squares[i];
                break;
            }
            sum += squares[j--];
            sum -= squares[i++];
        }
        return sum;
    }
}