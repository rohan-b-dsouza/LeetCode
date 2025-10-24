class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int l1 = landStartTime.length;
        int l2 = waterStartTime.length;
    
        int minTime = Integer.MAX_VALUE;
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                int landToWater = 0;
                landToWater += landStartTime[i] + landDuration[i];
                if (landToWater < waterStartTime[j]) {
                    landToWater = waterStartTime[j];
                }
                landToWater += waterDuration[j];
                
                int waterToLand = 0;
                waterToLand += waterStartTime[j] + waterDuration[j];
                if (waterToLand < landStartTime[i]) {
                    waterToLand = landStartTime[i];
                }
                waterToLand += landDuration[i];

                minTime = Math.min(minTime, Math.min(waterToLand, landToWater));
            }
        }
        return minTime;
        
    }
}