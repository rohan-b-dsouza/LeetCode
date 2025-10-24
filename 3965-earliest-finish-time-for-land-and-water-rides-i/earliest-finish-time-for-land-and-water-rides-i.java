// Brute - Works for the given constraints
// Refer 3633. Earliest Finish Time for Land and Water Rides II to see optimal solution for more tight constraints

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        // Get no. of land and water rides
        int l1 = landStartTime.length;
        int l2 = waterStartTime.length;
        // Initialize minimum time to maximum integer value
        int minTime = Integer.MAX_VALUE;
        // Compute time reqd for all possible pairs of land and water rides
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                // Case 1: Land First, Then Water
                // Add land ride start and end time
                int landToWater = landStartTime[i] + landDuration[i];
                // If the time is less than water ride start time then update time to water ride start time
                landToWater = Math.max(landToWater, waterStartTime[j]);
                // Add water ride end time to the time
                landToWater += waterDuration[j];

                // Case 2: Water First, Then Land

                // Add water ride start and end time
                int waterToLand = waterStartTime[j] + waterDuration[j];
                // If the time is less than land ride start time then update time to land ride start time
                waterToLand = Math.max(waterToLand, landStartTime[i]);
                // Add land ride end time to the time
                waterToLand += landDuration[i];

                // Update the minimum time seen so far
                minTime = Math.min(minTime, Math.min(waterToLand, landToWater));
            }
        }
        // Return minTime
        return minTime;
        
    }
}

// T.C => O(n ^ 2)
// S.C => O(1)