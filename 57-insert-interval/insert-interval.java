class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i = 0;
        // List to store interval arrays
        List<int[]> result = new ArrayList<>();
        // Loop to insert intervals that come before new interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            // Add all intervals that come before new interval
            result.add(intervals[i]);
            i++;
        }
        // Loop to merge the intervals overlapping with new interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        // After merging, add the merged interval to the result
        result.add(newInterval);

        // Now, add all the remaining intervals i.e intervals that come after the merge interval 
        // Since all the intervals initially are guaranteed to be non - overlapping this works
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        // Store the arrays in an array and return 
        int[][] ans = result.toArray(new int[result.size()][]);
        return ans;
    }
}