class Solution {
    public int earliestTime(int[][] tasks) {
        int min = Integer.MAX_VALUE;
        int n = tasks.length;
        for (int[] a : tasks) {
            min = Math.min(min, a[0] + a[1]);
        }
        return min;
    }
}