class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int m = s.length();
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int r = startPos[0]; int c = startPos[1];
            int instructions = 0;
            for (int j = i; j < m; j++) {
                if (s.charAt(j) == 'R' && (c + 1 < n)) {
                    c = c + 1;
                    instructions++;
                }
                else if (s.charAt(j) == 'L' && (c - 1 >= 0)) {
                    c = c - 1;
                    instructions++;
                }
                else if (s.charAt(j) == 'D' && (r + 1 < n)) {
                    r = r + 1;
                    instructions++;
                }
                else if (s.charAt(j) == 'U' && (r - 1 >= 0)) {
                    r = r - 1;
                    instructions++;
                }
                else break;
            }
            ans[i] = instructions;
        }
        return ans;
    }
}