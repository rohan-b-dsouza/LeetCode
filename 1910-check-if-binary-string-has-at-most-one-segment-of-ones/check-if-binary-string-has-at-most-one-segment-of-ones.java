class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        int totalCnt = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') cnt++;
            else if (cnt >= 1) {
                cnt = 0;
                totalCnt++;
            }
        }
        if (cnt > 0) totalCnt++;
        return totalCnt <= 1 ? true : false;
    }
}