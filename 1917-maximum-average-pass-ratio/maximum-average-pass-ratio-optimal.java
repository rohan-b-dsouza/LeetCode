// Optimal (Greedy)

class Solution {
    // Function to calculate gain i.e increase in pass ratio of individual class on adding an extra student
    private double gain(int pass, int total) {
        return (pass + 1.0) / (total + 1) - pass * 1.0 / total;
    }
// Function to calculate the maximum average pass ratio
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        // Priority Queue to efficiently get the maximum gain class
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Double.compare(gain(b[0], b[1]), gain(a[0], a[1])));
        // Step 1 : Add all classes to the Priority Queue
        for (int[] c : classes) {
            pq.offer(c);
        }
        // Step 2 : At each step, add the student to the class with maximum gain possible (Greedy Choice)
        while (extraStudents > 0) {
            // Pop and get the class with max possible gain
            int[] top = pq.poll();
            // Add student to the class
            top[0]++;
            top[1]++;
            // Put updated class to the max heap again to reorder
            pq.offer(top);
            // Decrement extraStudents
            extraStudents--;
        }
        // Step 3 : Sum all the updated pass ratios 
        double maxAvgPassRatio = 0;
        for (int[] x : pq) {
            maxAvgPassRatio += ((double) x[0] / x[1]);
        }
        // Return the maximum average pass ratio
        return maxAvgPassRatio / n;

    }
}

// T.C => O(n * log(n)) for building the PQ + O(extraStudents * (2 * log (n)) for the while loop + O(n) to iterate over the PQ
// Overall T.C => O((n + extraStudents) * log n)
// S.C => O(2 * n) = O(n) for storing all the classes
