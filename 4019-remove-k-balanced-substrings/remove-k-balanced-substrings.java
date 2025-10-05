class Solution {
    public String removeSubstring(String s, int k) {
        StringBuilder ans = new StringBuilder();
        int size = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            ans.append(s.charAt(i));
            size = ans.length();
            if (size >= 2 * k) {
                boolean valid = true;
                for (int j = 0; j < k; j++) {
                    if (ans.charAt(size - 2 * k + j) != '(') {
                        valid = false;
                        break;
                    }
                    if (ans.charAt(size - k + j) != ')') {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    ans.setLength(size - 2 * k);
                }

            }

        }
        return ans.toString();
    }
}