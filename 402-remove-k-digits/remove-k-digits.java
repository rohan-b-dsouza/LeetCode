class Solution {
    public String removeKdigits(String nums, int k) {
        int n = nums.length();
        if (k >= n) return "0";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            // Pop while last digit is bigger and we can still remove
            while (sb.length() > 0 && k > 0 && sb.charAt(sb.length() - 1) > nums.charAt(i)) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(nums.charAt(i));
        }

        // Remove remaining k digits from the end
        while (k > 0 && sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }

        // Remove leading zeros in O(n), not by repeated inbuilt deleteCharAt() func that takes O(n) every time
        int idx = 0;
        while (idx < sb.length() && sb.charAt(idx) == '0') idx++;

        // If all removed or all zeros, return "0"
        return idx == sb.length() ? "0" : sb.substring(idx);
    }
}
