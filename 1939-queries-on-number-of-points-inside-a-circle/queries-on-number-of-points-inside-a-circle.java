class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int q = queries.length;
        int n = points.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int xj = queries[i][0]; int yj = queries[i][1]; int r = queries[i][2];
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                int x = points[j][0]; int y = points[j][1];
                if ((x - xj) * (x - xj) + (y - yj) * (y - yj) <= r * r)  {
                    cnt++;
                }
            }
            ans[i] = cnt; 
        }
        return ans;
    }
}