// Optimal

class Solution {
    public String removeSubstring(String s, int k) {
        StringBuilder ans = new StringBuilder();
        int size = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            // Put current character in the StringBuilder
            ans.append(s.charAt(i));
            // Get StringBuilder's current size
            size = ans.length();
            // If the size is >= 2*k, we can check for a k - balanced substring
            if (size >= 2 * k) {
                // Set valid flag to true, this tracks whether its a valid k - balanced substring
                boolean valid = true;
                // Now, iterate over the last 2*k size substring
                for (int j = 0; j < k; j++) {
                    // Check if the left k characters are '(', if not set valid flag to false and break as this is not a k - balanced substring
                    if (ans.charAt(size - 2 * k + j) != '(') {
                        valid = false;
                        break;
                    }
                    // Check if the right k characters are ')', if not set valid flag to false and break as this is not a k - balanced substring 
                    if (ans.charAt(size - k + j) != ')') {
                        valid = false;
                        break;
                    }
                }
                // If valid flag is true after the inner for loop check, then it means its a k - balanced substring, hence remove the last 2 * k characters from the StringBuilder
                if (valid) {
                    // setLength() will remove the last 2 * k characters
                    ans.setLength(size - 2 * k);
                }
            }
        }
        // Return the StringBuilder as a String
        return ans.toString();
    }
}

// T.C : O(n * k) as in the worst case there will be no k - balanced substring and every k sized substring will be checked using inner loop
// However, Amortised (Average) T.C => O(n)
// S.C : O(n)
