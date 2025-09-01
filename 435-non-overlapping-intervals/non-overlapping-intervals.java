class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int NonOverlappingPairsCnt = 0;
        int lastPairEnd = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (intervals[i][0] >= lastPairEnd) {
                NonOverlappingPairsCnt++;
                lastPairEnd = intervals[i][1];
            }
        }
        return n - NonOverlappingPairsCnt;
    }
}