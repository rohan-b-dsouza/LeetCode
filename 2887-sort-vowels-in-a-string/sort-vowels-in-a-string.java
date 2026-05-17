class Solution {
    public boolean isVowel(char c) {
        char ch = Character.toLowerCase(c);
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }
    public String sortVowels(String s) {
        int n = s.length();
        String range = "AEIOUaeiou";
        int[] freq = new int[128];
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                freq[ch]++;
            } 
            else {
                ans[i] = ch;
            }
        }
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (ans[i] == 0) {
                while (freq[range.charAt(idx)] == 0) {
                    idx++;
                }
                ans[i] = range.charAt(idx);
                freq[range.charAt(idx)]--;
            }
        }
        String result = new String(ans);
        return result;
    }
}