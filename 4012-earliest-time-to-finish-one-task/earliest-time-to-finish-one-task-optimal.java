// Optimal

class Solution {
    public int earliestTime(int[][] tasks) {
        int min = Integer.MAX_VALUE;
        int n = tasks.length;
        for (int[] a : tasks) {
            // At each step, update the minimum earliest time seen so far
            min = Math.min(min, a[0] + a[1]);
        }
        return min;
    }
}

// T.C => O(n)
// S.C => O(1)
