class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            // we reached an index which is not reachable using valid jumps
            if (i > maxIdx) return false;
            // Update the maximum reachable index
            maxIdx = Math.max(maxIdx, i + nums[i]);
            // if we last index is reachable, return early
            if (maxIdx >= n - 1) return true;
        }
        // Return true as last index is reachable
        return true;
    }
}

// Greedy Approach :-
/* At each index i, you look at how far you can currently jump (i + nums[i]) and update maxIdx to be the farthest reachable index so far.

This is greedy because:

You don’t explore all possible paths.

You always “grab” the maximum reach at every step without backtracking.

If at any point i > maxIdx, it means you’re stuck (greedy choice failed), so you return false.

So the greedy strategy is: Always jump as far as possible from the reachable positions. 
*/