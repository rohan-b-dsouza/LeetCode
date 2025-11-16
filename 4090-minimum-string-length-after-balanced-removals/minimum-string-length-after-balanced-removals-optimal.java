// Optimal

class Solution {
    public int minLengthAfterRemovals(String s) {
        int cnta = 0;
        int cntb = 0;
        // Get the count of 'a's and 'b's in the string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') cnta++;
            else cntb++;
        }
        // The minimum possible length of the string after removals is abs(a - b)
        return (Math.abs(cnta - cntb));
    }
}

// T.C => O(n)
// S.C => O(1)
