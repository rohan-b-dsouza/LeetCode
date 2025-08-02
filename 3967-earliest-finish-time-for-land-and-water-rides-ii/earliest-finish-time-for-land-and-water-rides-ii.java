class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int l1 = landStartTime.length;
        int w1 = waterStartTime.length;
        int minTime = Integer.MAX_VALUE;
        int minLand = Integer.MAX_VALUE;
        for (int i = 0; i < l1; i++) {
            minLand = Math.min(minLand, landStartTime[i] + landDuration[i]);
        }
        for (int j = 0; j < w1; j++) {
            if (minLand < waterStartTime[j]) {
                minTime = Math.min(minTime, waterStartTime[j] + waterDuration[j]);
            }
            else {
                minTime = Math.min(minTime, minLand + waterDuration[j]);
            }
        }
        int minWater = Integer.MAX_VALUE;
        for (int i = 0; i < w1; i++) {
            minWater = Math.min(minWater, waterStartTime[i] + waterDuration[i]);
        }
        for (int j = 0; j < l1; j++) {
            int sum = 0;
            if (minWater < landStartTime[j]) {
                minTime = Math.min(minTime, landStartTime[j] + landDuration[j]);
            }
            else {
                minTime = Math.min(minTime, minWater + landDuration[j]);
            }
        }
        return minTime;
        
    }
}