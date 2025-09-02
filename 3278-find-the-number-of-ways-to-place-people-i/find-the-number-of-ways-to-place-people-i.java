class Solution {
    public boolean noOtherPoints(int[][] points, int n, int i, int j, int Ax, int Ay, int Bx, int By) {
        for (int k = 0; k < n; k++) {
            if (k != i && k != j) {
                int Px = points[k][0];
                int Py = points[k][1];
                if ((Px >= Ax && Px <= Bx) && (Py <= Ay && Py >= By)) {
                    return false;
                } 
            }
        }
        return true;
    }
    public int numberOfPairs(int[][] points) {
        int cnt = 0;
        int n = points.length;
        Arrays.sort(points, (a, b) -> {
    if (a[0] != b[0]) return a[0] - b[0];
    return b[1] - a[1]; // higher y first
});
        for (int i = 0; i < n; i++) {
            int Ax = points[i][0];
            int Ay = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int Bx = points[j][0];
                int By = points[j][1];
                if ((Ax <= Bx && Ay >= By) && (noOtherPoints(points, n, i, j, Ax, Ay, Bx, By))) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}