class Solution {
    public int minLengthAfterRemovals(String s) {
        int cnta = 0;
        int cntb = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') cnta++;
            else cntb++;
        }
        return (Math.abs(cnta - cntb));
    }
}