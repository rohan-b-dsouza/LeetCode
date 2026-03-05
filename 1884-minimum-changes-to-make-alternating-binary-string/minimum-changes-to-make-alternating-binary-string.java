class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char ch1 = '0';
        char ch2 = '1';
        int min1 = 0;
        int min2 = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ch1) {
                min1++;
            }
            if (ch != ch2) {
                min2++;
            }
            ch1 = ch1 == '0' ? '1' : '0';
            ch2 = ch2 == '0' ? '1' : '0';
        }
        return Math.min(min1, min2);
    }
}