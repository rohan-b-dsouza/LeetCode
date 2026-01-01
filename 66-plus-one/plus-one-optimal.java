// Optimal

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
        // If digit is smaller than 9 add 1 to it and return the array
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // If digit is 9, make it zero
            digits[i] = 0;
        }
        // If all digits are 9, create a new array with first element as 1 and all zeroes
        int[] ans = new int[n + 1];
        ans[0] = 1;
        // Return ans
        return ans;
    }
}

// T.C => O(n)
// S.C => O(n) extra space reqd for edge case where all values are 9
