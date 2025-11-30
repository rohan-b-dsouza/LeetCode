// Optimal

class Solution {
    public int countElements(int[] nums, int k) {
        int n = nums.length;
        // Sort the array so that all >= elements of an element are on its right side
        Arrays.sort(nums);
        int ans = 0;
        int i = 0;
        // Set freq to 1
        int freq = 1;
        // While i is < n
        while (i < n) {
            // If we are at the last element or if next element is not equal to current element
            if (i == n - 1 || nums[i] != nums[i + 1]) {
                // Compute the elements that are greater than our current element
                int greater = n - i - 1;
                // If its greater than equal to k, the current element is a 'qualified' element
                if (greater >= k) {
                    // Add freq of this 'qualified' element to the ans
                    ans += freq;
                    // Reset freq to 1
                    freq = 1;
            }
            }
            // If current element and next element are both same, increment the freq
            else {
                freq++;
            }
            // Increment i pointer in each step
            i++;
        }
    // Return the answer
        return ans;
    }
}

// T.C => O(n * log(n)) + O(n) = O(n * log(n))
// S.C => O(1)
