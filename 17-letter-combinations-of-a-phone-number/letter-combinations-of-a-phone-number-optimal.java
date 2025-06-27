// Optimal

class Solution {
  public void getLetterCombinations(
      int index, String combination, String[] map, List<String> ans, String digits) {
    if (index == digits.length()) { // Base case: if index reaches the end of digits
      ans.add(combination); // Add the current combination to the answer
      return;
    }
    // Get string corresponding to the current digit
    String s = map[digits.charAt(index) - '0'];
    // Loop through the corresponding characters
    for (int i = 0; i < s.length(); i++) {
      // Recursively call the function with next index
      // Add current character to the string
      getLetterCombinations(index + 1, combination + s.charAt(i), map, ans, digits);
    }
  }

  public List<String> letterCombinations(String digits) {
    List<String> ans = new ArrayList<>();
    if (digits.length() == 0) return ans;
    String[] map = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    getLetterCombinations(0, "", map, ans, digits);
    return ans;
  }
}

// T.C => O(4^n * n) 
// S.C => O(n) for recursion depth and O(4^n * n) for result storage
