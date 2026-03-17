class Solution {
    public String trimTrailingVowels(String s) {
        StringBuilder sb = new StringBuilder("");
        int idx = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                idx = i;
                break;
            }
        }
        if (idx == -1) return ""; 
        return s.substring(0, idx + 1);
    }
}