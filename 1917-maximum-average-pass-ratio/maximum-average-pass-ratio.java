import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare((b[0]+1.0)/(b[1]+1) - (b[0]*1.0)/b[1],
                                     (a[0]+1.0)/(a[1]+1) - (a[0]*1.0)/a[1])
        );

        for (int[] c : classes) pq.offer(c);

        while (extraStudents-- > 0) {
            int[] top = pq.poll();
            top[0] += 1;
            top[1] += 1;
            pq.offer(top);
        }

        double res = 0;
        while (!pq.isEmpty()) {
            int[] c = pq.poll();
            res += (double)c[0]/c[1];
        }

        return res / classes.length;
    }
}
