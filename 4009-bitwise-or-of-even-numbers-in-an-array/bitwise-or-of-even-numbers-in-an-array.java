class Solution {
    
    public int evenNumberBitwiseORs(int[] nums) {
        int n = nums.length;
        int or = 0;
        for (int i = 0; i < n; i++) {
           if ((nums[i] & 1) == 0) or |= nums[i]; 
        }
        return or;
    }
    
}