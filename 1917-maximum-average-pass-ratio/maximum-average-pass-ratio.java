class Solution {
    private double gain(int pass, int total) {
        return (pass + 1.0) / (total + 1) - pass * 1.0 / total;
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Double.compare(gain(b[0], b[1]), gain(a[0], a[1])));
        for (int[] c : classes) {
            pq.offer(c);
        }
        while (extraStudents > 0) {
            int[] top = pq.poll();
            top[0]++;
            top[1]++;
            pq.offer(top);
            extraStudents--;
        }
        double maxAvgPassRatio = 0;
        for (int[] x : pq) {
            maxAvgPassRatio += ((double) x[0] / x[1]);
        }
        return maxAvgPassRatio / n;

    }
}