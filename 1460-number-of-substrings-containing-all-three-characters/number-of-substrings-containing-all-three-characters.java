class Solution {    
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        // Hash array to map the characters with their last seen index position
        int[] hash = new int[] {-1, -1, -1};
        for (int i = 0; i < n; i++) {
            // Store the index of current character
            hash[s.charAt(i) - 'a'] = i;
            // Compute the  valid substrings ending at current index    
            ans += Math.min(hash[0], Math.min(hash[1], hash[2])) + 1;
        }
        // Return the ans
        return ans;
    }
}