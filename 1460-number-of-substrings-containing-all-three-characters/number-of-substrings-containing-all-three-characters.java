class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int ans = 0, l = 0;
        int[] hash = new int[3];
        int r = 0;
        while (r < n) {
            hash[s.charAt(r) - 'a']++;
            
            while (hash[0] > 0 && hash[1] > 0 && hash[2] > 0) {
                ans += s.length() - r;
                hash[s.charAt(l++) - 'a']--;
            }
            r++;
        }

        return ans;
    }
}
