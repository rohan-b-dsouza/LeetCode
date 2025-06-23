class Solution {
    public void generate(int open, int close, String current, int n, List<String> result) {
        
        if (open == close && open + close == 2 * n) {
            result.add(current);
            return;
        }
        if (open < n) {
            generate(open + 1, close, current + "(", n, result); 
        }
        if (close < open) {
            generate(open, close + 1, current + ")", n, result);
        }
    }
    public List<String> generateParenthesis(int n) {
         List<String> result = new ArrayList<>();
        generate(0, 0, "", n, result);
        return result;
    }
}
