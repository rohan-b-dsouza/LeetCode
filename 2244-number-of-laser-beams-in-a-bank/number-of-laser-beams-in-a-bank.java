class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int prev = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int curr = 0;
            String str = bank[i];
            for (int j = 0; j < str.length(); j++) {
                curr += str.charAt(j) - '0';
            }
            if (curr != 0)  {
                ans += (curr * prev);
                prev = curr;
            }
        }
        return ans;
    }
}