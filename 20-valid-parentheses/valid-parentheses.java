class Solution {
  public boolean isValid(String s) {
    int n = s.length();
    Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      char ch = s.charAt(i);
      if (ch == '(' || ch == '{' || ch == '[') {
        stack.push(ch);
      } else {
        if (stack.isEmpty()) return false;
        char opening = stack.pop();
        if ((opening == '(' && ch == ')') || (opening == '[' && ch == ']') || (opening == '{' && ch == '}')) {
            continue;
        }
        return false;
      }
    }
    return stack.isEmpty();
  }
}
