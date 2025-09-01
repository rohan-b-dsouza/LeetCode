// Brute

// Note :- Gain basically refers to how much increment a class shows in its pass ratio when an extra student is added
// We greedily choose the class with max possible gain in each step and add student to it, to ensure that globally we get optimal (maximum) avg pass ratio

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
      // Loop over extraStudents
        for (int i = 1; i <= extraStudents; i++) {
          // Initialize maxGain to min value  
          double maxGain = -1.0;
          // Set a variable to store the idx of the class with maximum gain possible when an extra student is added
            int maxGainClassIdx = -1;
          // Check which class has maximum gain when an extra student is added
            for (int j = 0; j < n; j++) {
                double pass = classes[j][0];
                double total = classes[j][1];
                double gain = ((pass + 1) / (total + 1)) - (pass / total);
              // If gain is greater than maxGain, update maxgain and store the idx of this class
                if (gain > maxGain) {
                    maxGain = gain;
                    maxGainClassIdx = j;
                }
            }
          // Update the pass and total by +1 for the class of maximum gain
            classes[maxGainClassIdx][0] += 1;
            classes[maxGainClassIdx][1] += 1;
        }
      // After all classes have been updated, sum all the pass ratios
        double maxAvgPassRatio = 0;
        for (int i = 0; i < n; i++) {
            maxAvgPassRatio += (double) classes[i][0] / classes[i][1];
        }
      // Return the maximum avg pass ratio
        return maxAvgPassRatio / n;
    }
}

// T.C => O()
// S.C => 
