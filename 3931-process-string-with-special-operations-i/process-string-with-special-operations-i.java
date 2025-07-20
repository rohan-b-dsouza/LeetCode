// Optimal 

class Solution {
    public String processStr(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                str.append(s.charAt(i));
            }
            else if (s.charAt(i) == '*') {
                if (str.length() > 0) {
                    str.deleteCharAt(str.length() - 1);
                }
            }
            else if (s.charAt(i) == '#') {
                str.append(str);
            }
            else if (s.charAt(i) == '%') {
                str.reverse();
            }
        }
        return str.toString();
    }
}

// T.C => O(2^k) in the worst case where k is the number of # characters; since each # doubles the current string
// S.C => O(2^k) in the worst case where k is the number of # characters; since each # doubles the current string
