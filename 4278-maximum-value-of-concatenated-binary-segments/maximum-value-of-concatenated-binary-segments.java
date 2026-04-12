class Solution {
    public int maxValue(int[] nums1, int[] nums0) {
        int MOD = 1000000007;
        int n = nums1.length;
        List<String> segments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= nums1[i]; j++) {
                sb.append('1');
            }
            for (int k = 1; k <= nums0[i]; k++) {
                sb.append('0');
            }
            segments.add(sb.toString());
        }
        segments.sort((a, b)-> {
            return (b + a).compareTo(a + b);
        });
        StringBuilder finalString = new StringBuilder();
        for (String str : segments) {
            finalString.append(str);
        }
        int ans = 0;
        for (int i = 0; i < finalString.length(); i++) {
            char ch = finalString.charAt(i);
            ans = ((ans * 2) % MOD + (ch - '0')) % MOD;
        }
        return ans;

    }
}