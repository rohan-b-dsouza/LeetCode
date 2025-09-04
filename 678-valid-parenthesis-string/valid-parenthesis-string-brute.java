// Brute Force (Recursive) 
// IMP Note :- This recursive solution can be further optimised using DP (Memoization), so implement that once DP is studied 

class Solution {
    // Recursive Function to check valid parentheses
    public boolean checkValidParenthesis(String s, int idx, int cnt) {
        // If cnt becomes zero it means the current parentheses arrangement is invalid as all '(' have corresponding ')' to balance it out
        if (cnt < 0) return false;
        // If all characters are processed, check whether cnt is 0.
        // If so then its a valid parenthesis string, else return false
        if (idx == s.length()) {
            return cnt == 0;
        }  
        // If a '(' occurs then increment counter and recursively check for next indices
        if (s.charAt(idx) == '(') {
            return checkValidParenthesis(s, idx + 1, cnt + 1);
        }
        // If a ')' occurs then decrement counter and recursively check for next indices
        else if (s.charAt(idx) == ')') {
            return checkValidParenthesis(s, idx + 1, cnt - 1);
        }
        // If an '*' occurs recursively check all possiblities i.e '(', ')', & '' (empty) 
        return checkValidParenthesis(s, idx + 1, cnt + 1) || checkValidParenthesis(s, idx + 1, cnt - 1) || checkValidParenthesis(s, idx + 1, cnt);
    }
    public boolean checkValidString(String s) {
        // Call the Recursive Function
        return checkValidParenthesis(s, 0, 0);
    }
}

// T.C => O(3^k) where k is the number of asterisks as for every asterisk we need to explore 3 paths (-1,+0,+1)
// S.C => O(n) due to recursion stack
