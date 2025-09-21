// Optimal (Bit Manipulation)

class Solution {
    
    public int evenNumberBitwiseORs(int[] nums) {
        int n = nums.length;
        int or = 0;
        for (int i = 0; i < n; i++) {
            // If number is even (i.e LSB = 0) 'OR' it with or
           if ((nums[i] & 1) == 0) or |= nums[i]; 
        }
        return or;
    }
    
}

// T.C => O(n)
// S.C => O(1)
