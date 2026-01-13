// Optimal

// Logic:- Create a freq array. Increment count of a character in case of s, and decrement in case of t. If s and t are anagrams, the no. of characters and type of characters will be balanced hence the array should have only zeroes at the end.
// If not then return false.

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] str = new int[26];
        for (int i = 0; i < s.length(); i++) {
            str[s.charAt(i) - 'a']++;
            str[t.charAt(i) - 'a']--;
        } 
        for (int num : str) {
            if (num != 0) return false;
        }
        return true;
    }
}

// T.C => O(n)
// S.C => O(26) = O(1)
