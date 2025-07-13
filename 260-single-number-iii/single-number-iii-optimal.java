// Optimal

class Solution {    
    public int[] singleNumber(int[] nums) { 
        int n = nums.length;       
        int zeroes = 0;
        int ones = 0;
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }
        int rightmostSetBit = xor & ~(xor - 1);
        for (int i = 0; i < n; i++) {
            if ((nums[i] & rightmostSetBit) != 0) {
                ones ^= nums[i];
            }
            else {
                zeroes ^= nums[i];
            }
        }
        if (ones < zeroes) {
            return new int[] {ones, zeroes};
        }
        return new int[] {zeroes, ones};
    }
}

// T.C => O(n)
// S.C => O(1)
