// Optimal (Monotonic Increasing Stack + Greedy)
// Here, we used StringBuilder like a stack as this is the most efficient way to solve this problem. Otherwise if we use a Deque (Stack) it would anyways require a StringBuilder too

class Solution {
    public String removeKdigits(String nums, int k) {
        int n = nums.length();
        // Edge Case : If no. of digits to remove are more than the size of string its not possible to do so
        if (k >= n) return "0";
        // Using StringBuilder as a stack
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            // If stack (StringBuilder) is not empty and k is not zero and current character is smaller than stack's top, pop the stack's top and decrement k
            while (sb.length() > 0 && k > 0 && nums.charAt(i) < sb.charAt(sb.length() - 1)) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            // Push the current character on the stack
            sb.append(nums.charAt(i));
        }

        // If k is still not zero remove the character's at the top of the stack till k > 0
        while (k > 0 && sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }
    
        // Remove leading zeros in overall O(n), not by repeated inbuilt deleteCharAt() func that takes O(n) every time to remove first character every time
        int idx = 0;
        // Traverse over the StringBuilder and increment idx till a non - zero element is found to eliminate all leading zeroes
        while (idx < sb.length() && sb.charAt(idx) == '0') idx++;

        // If idx is out of bounds it means all characters are 0s hence return "0", else return the substring {idx, n - 1}
        return idx == sb.length() ? "0" : sb.substring(idx);
    }
}

// T.C => O(n + k) + O(k) + O(n) = O(2 * (n + k)) = O(n)
// S.C => O(n - k) = O(n)
