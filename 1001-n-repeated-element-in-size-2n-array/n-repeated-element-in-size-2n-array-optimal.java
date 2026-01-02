// Optimal (Observation + Pigeon hole principle)

class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        // Intuition:
        // Array size = 2n
        // One element appears n times
        // Remaining n elements appear once
        // There are not enough unique elements to separate all repeated elements
        // by more than 2 positions.
        // Hence, at least one pair of repeated elements must occur at index
        // difference ≤ 2 (i+1 or i+2).

        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == nums[i + 1] || (nums[i] == nums[i + 2])) {
                return nums[i];
            }
        }       
        // Edge Case:- [9,5,6,9], [2,1,5,3,2,2]
        return nums[n - 1];
    }
}

// Pigeonhole Principle:
// There are n repeated elements but only n unique elements available
// to separate them. To avoid distance ≤ 2, each repeated element would
// need two unique separators, which is impossible.
// Hence, a collision within distance 2 is guaranteed.

// T.C => O(n)
// S.C => O(1)
