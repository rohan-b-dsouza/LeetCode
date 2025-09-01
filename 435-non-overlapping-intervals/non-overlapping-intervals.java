// Optimal

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        // Sort the intervals based on end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int NonOverlappingPairsCnt = 0;
        int lastPairEnd = Integer.MIN_VALUE;
        // Count the non-overlapping intervals greedily 
        for (int i = 0; i < n; i++) {
            // if current interval start time is greater than last interval end time, select it 
            if (intervals[i][0] >= lastPairEnd) {
                // Increment no. of non overlapping intervals
                NonOverlappingPairsCnt++;
                // Update lastPairEnd to end time of newly selected interval
                lastPairEnd = intervals[i][1];
            }
        }
        // Return the minimum no. of intervals not selected (removed)
        return n - NonOverlappingPairsCnt;
    }
}

// T.C => O(n * (log n)) + O(n) = O(n * log(n))
// S.C => O(1)
