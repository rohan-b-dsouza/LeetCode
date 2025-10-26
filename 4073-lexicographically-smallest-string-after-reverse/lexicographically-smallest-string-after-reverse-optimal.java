// Optimal

class Solution {
    public String lexSmallest(String s) {
        int n = s.length();
        // Stores the answer
        StringBuilder ans = new StringBuilder("");
        // For each i, get the first i and last i reversed strings
        for (int i = 1; i <= n; i++) {
            StringBuilder firstK = new StringBuilder(s.substring(0, i)).reverse().append(s.substring(i));
            StringBuilder lastK = new StringBuilder(s.substring(0, n - i));
            lastK.append(new StringBuilder(s.substring(n - i)).reverse());
            // If ans is empty or firstK string is smaller than lastK then update ans to firstK
            if ((ans.length() == 0) || (firstK.compareTo(ans) < 0)) ans = firstK;
            // Else update ans to lastK
            if (lastK.compareTo(ans) < 0) ans = lastK;
        }
        // Return ans as string
        return ans.toString();
    }
}

// T.C => O(n ^ 2)
// S.C => O(3 * n) = O(n) 
