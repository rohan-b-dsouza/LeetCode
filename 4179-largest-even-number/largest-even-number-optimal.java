// Optimal

// Logic:- Since we want the largest number, we will remove the digits from the end if its not even.
// At any point, if we get even number just break early.
// Return the substring

class Solution {
    public String largestEven(String s) {
        int n = s.length();
        int i = n - 1;
        while (i >= 0) {
            if (s.charAt(i) % 2 == 0) {
                break;
            }
            i--;
        }
        return i == -1 ? "" : s.substring(0, i + 1);
    }
}

// T.C => O(n)
// S.C => O(1)
