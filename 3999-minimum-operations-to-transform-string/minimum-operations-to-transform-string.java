class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int minOperations = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int dist = (26 - (ch - 'a')) % 26;
            minOperations = Math.max(minOperations, dist);
        }
        return minOperations;
    }
}