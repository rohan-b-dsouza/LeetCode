class Solution {
    public String largestEven(String s) {
        int n = s.length();
        int i = n - 1;
        while (i >= 0) {
            if (s.charAt(i) % 2 == 0) {
                break;
            }
            i--;
        }
        return i == -1 ? "" : s.substring(0, i + 1);
    }
}