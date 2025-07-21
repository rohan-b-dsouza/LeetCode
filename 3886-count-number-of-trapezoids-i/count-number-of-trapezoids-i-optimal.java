// Optimal 

class Solution {
    public int countTrapezoids(int[][] points) {
        final int MOD = 1_000_000_007;
        // Map for mapping (key : y, value : freq(y))
        HashMap <Integer, Integer> yfreq = new HashMap<>();
        // Map frequency of every 'y' coordinate in the map 
        for (int i = 0; i < points.length; i++) {
            int y = points[i][1];
            yfreq.put(y, yfreq.getOrDefault(y, 0) + 1);
        }
        long total = 0;
        // add the total possible pairs using the formula n * (n - 1) / 2
        for (int freq : yfreq.values()) {
            total += ((long) freq * (freq - 1)) / 2;
        }
        long trapezoids = 0;
        // calculate the trapezoids optimally 
        for (int freq : yfreq.values()) {
            long pairCount = ((long) freq * (freq - 1)) / 2;
            total -=  pairCount;
            trapezoids = (trapezoids + (total * pairCount)) ;
        }
        return (int) (trapezoids % MOD); 
    }
}

// T.C => O(n)
// S.C => O(n)
