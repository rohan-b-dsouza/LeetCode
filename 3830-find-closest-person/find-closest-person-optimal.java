// Optimal

class Solution {
    public int findClosest(int x, int y, int z) {
        // If x is closer to z return 1
        if (Math.abs(x - z) < Math.abs(y - z)) return 1;
        // If y is closer to z return 2
        if (Math.abs(y - z) < Math.abs(x - z)) return 2;
        // If both are equally closer to z return 0
        return 0;
    }
}

// T.C => O(1)
// S.C => O(1)
