class Solution {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int n = towers.length;
        int[] ans = {-1, -1};
        int maxQf = -1;
        for (int i = 0; i < n; i++) {
          int x = towers[i][0];
          int y = towers[i][1];
          int currQf = towers[i][2];
          int dist = Math.abs(x - center[0]) + Math.abs(y - center[1]);
          if (dist <= radius) {
            if (currQf > maxQf) {
              ans[0] = x;
              ans[1] = y;
              maxQf = currQf;
            }
            else if (currQf == maxQf) {
              if (x > ans[0] || (x == ans[0] && y > ans[1])) continue;
              ans[0] = x;
              ans[1] = y;
            }
          }
        }
        return ans;
    }
}