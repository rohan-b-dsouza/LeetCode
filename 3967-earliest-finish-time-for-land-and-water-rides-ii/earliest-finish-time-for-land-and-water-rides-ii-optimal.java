// Optimal (Greedy Approach)
// Refer 3633. Earliest Finish Time for Land and Water Rides I for brute solution of same solution with easier constraints

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int l1 = landStartTime.length;
        int w1 = waterStartTime.length;
        int minTime = Integer.MAX_VALUE;
        
        // Case 1 : First Land, Then Water
        int minLand = Integer.MAX_VALUE;
        // Get the land ride with minimum reqd completion time
        for (int i = 0; i < l1; i++) {
            minLand = Math.min(minLand, landStartTime[i] + landDuration[i]);
        }

        int minWater = Integer.MAX_VALUE;
        // Find the water ride which adds least possible time to this time
        for (int j = 0; j < w1; j++) { 
            minTime = Math.min(minTime, Math.max(waterStartTime[j], minLand) + waterDuration[j]);
            // Get the water ride with minimum reqd completion time in this loop itself instead of using separate loop for this
            minWater = Math.min(minWater, waterStartTime[j] + waterDuration[j]);
        }

        // Case 2 : First Water, then Land
        // We have computed the water ride with minimum reqd completion time in previous loop itself
        // Now, Find the land ride which adds least possible time to this time

        for (int j = 0; j < l1; j++) {
            minTime = Math.min(minTime, Math.max(landStartTime[j], minWater) + landDuration[j]);
        }

        // Return minTime;
        return minTime;
    }
}

// T.C => O((2 * n) + m)) = O(n + m)
// S.C => O(1)
