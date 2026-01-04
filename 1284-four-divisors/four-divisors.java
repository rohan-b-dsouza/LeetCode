class Solution {
    public int getDivisors(int num) {
        int cnt = 0;
        int sum = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (cnt > 4)
                break;
            if (num % i == 0) {
                cnt++;
                sum += i;
                if (i != num / i) {
                    cnt++;
                    sum += num / i;
                }
            }
        }
        return cnt == 4 ? sum : 0;
    }

    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += getDivisors(nums[i]);
        }
        return sum;
    }
}