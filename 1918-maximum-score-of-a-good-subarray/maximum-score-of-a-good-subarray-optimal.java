// Optimal (Greedy)

// Logic:- Greedy always chooses the side that lets you keep the bar (minimum) as high as possible for as long as possible.
// Problem Insight:
// We need a subarray that includes index k and maximizes:
// min(subarray) * length(subarray)

// Key Idea:
// Start from index k and expand the window greedily.

// Greedy Strategy:
// At each step, expand towards the side with the LARGER adjacent value.
// This delays the decrease of the current minimum as much as possible.

// Why Greedy Works:
// Once the minimum of the window decreases, it can NEVER increase again.
// So we always choose the side that keeps the minimum as high as possible
// for as long as possible.

// Invariant:
// For each possible minimum value, this greedy process considers the
// widest subarray containing k with that minimum.
// Hence, we get the best possible score for every candidate minimum.

class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int i = k;
        int j = k;
        int currMin = nums[k];
        long ans = currMin;
        while (i - 1 >= 0 || j + 1 < n) {
            if (i - 1 >= 0 && j + 1 < n) {
                if (nums[i - 1] >= nums[j + 1]) {
                    currMin = Math.min(nums[i - 1], currMin);
                    i--;
                }
                else {
                   currMin = Math.min(nums[j + 1], currMin);
                   j++;
                }
            }
            else if (i - 1 < 0) {
                currMin = Math.min(nums[j + 1], currMin);
                j++;
            }
            else {
                currMin = Math.min(nums[i - 1], currMin);
                i--;
            }
            ans = Math.max(ans, currMin * 1L * (j - i + 1));
        }
        return (int) ans;
    }
}

// T.C => O(n)
// S.C => O(1)
