class Solution {
    public String maxSumOfSquares(int num, int sum) {
        int runningSum = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= num; i++) {
            int digit = Math.min(9, sum - runningSum);
            runningSum += digit;
            ans.append((char) (digit + '0'));
        }
        return (runningSum == sum) ? ans.toString() : "";
    }
}