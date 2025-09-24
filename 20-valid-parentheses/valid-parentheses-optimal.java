// Optimal (Stack)

class Solution {
  public boolean isValid(String s) {
    int n = s.length();
    Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      // Store current character
      char ch = s.charAt(i);
      // If its an opening bracket push it in the stack
      if (ch == '(' || ch == '{' || ch == '[') {
        stack.push(ch);
        // If its a closing bracket, check following conditions :-
      } else {
        // If the stack is empty, then there is no corresponding opening bracket for the closing bracket, hence return false
        if (stack.isEmpty()) return false;
        // If stack is not empty, store the stack top as opening character
        char opening = stack.pop();
        // If opening and closing brackets are same then continue else return false
        if ((opening == '(' && ch == ')') || (opening == '[' && ch == ']') || (opening == '{' && ch == '}')) {
            continue;
        }
        return false;
      }
    }
    // Atlast, check if the stack is empty, If so it means all closing brackets got their corresponding opening brackets, hence returns true. If stack is not empty it means some opening brackets were left alone, hence returns false.
    return stack.isEmpty();
  }
}

// T.C => O(n)
// S.C => O(1)
