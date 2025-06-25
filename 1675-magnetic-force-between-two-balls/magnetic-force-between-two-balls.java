class Solution {
    public boolean canWeAssignCows(int[] position, int minDist, int cows) {
        int lastcow = position[0];
        int cowsAssigned = 1;
        for (int i = 1; i < position.length; i++) {
            if ((position[i] - lastcow) >= minDist) {
                lastcow = position[i];
                cowsAssigned++;
            }
            if (cowsAssigned == cows)
                return true;
        }
        return false;
    }

    public int maxDistance(int[] position, int m) {
        int n = position.length;
        int low = 1;
        Arrays.sort(position);
        int high = position[n - 1];
        int min = position[0];
        if (m == 2)
            return high - min;
        high = high - min; // as high = max - min,
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canWeAssignCows(position, mid, m)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
