class Solution {
    public void generateCombinations(int open, int close, int n, String curr, List<String> result) {
        /**
         * A recursive helper function to generate all combinations
         * of balanced parentheses.
         *
         *  open - The number of open parentheses used so far.
         *  close - The number of close parentheses used so far.
         *  n - The total number of pairs of parentheses.
         *  curr - The current string being built.
         *  result - The list storing all valid combinations.
         */
         // Base case: if the number of open and close parentheses used
        // is equal to the total number of pairs, add the string to the result.
        if (open == close && open + close == 2 * n) {
            result.add(curr);
            return;
        }
        // If the number of open parentheses used is less than the total
        // number of pairs, add an open parenthesis and call the function recursively
        if (open < n) {
            generateCombinations(open + 1, close, n, curr + '(', result);
        }
        //If the number of close parentheses used is less than the number
        // of open parentheses, add a close parenthesis and call the function recursively
        if (close < open) {
            generateCombinations(open, close + 1, n, curr + ')', result);
        }
        
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateCombinations(0, 0, n, "", result); // start recursion with initial values
        return result;
    }
}