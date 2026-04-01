class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] ans = new int[n];
        ans[0] = pref[0];
        int runxor = pref[0];
        for (int i = 1; i < n; i++) {
            int reqd = runxor ^ pref[i];
            runxor ^= reqd;
            ans[i] = reqd;
        }
        return ans;
    }
}