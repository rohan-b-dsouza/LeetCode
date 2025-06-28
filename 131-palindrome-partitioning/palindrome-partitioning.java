class Solution {
    // Check if substring is a palindrome
    public boolean isPalindrome(String s, int start, int end) { 
        while (start < end) { 
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
    
    public void getPalindromePartitions(int index, List<String> partition, List<List<String>> ans, String s)  {
        // Base Case : if index exceeds string length, then a partition is formed
        if (index == s.length()) {
            ans.add(new ArrayList<>(partition));
            return;
        }
       // Iterate over the substring starting from 'index' to explore possible paths
        for (int i = index; i < s.length(); i++) {
            // Check if the substring s[index..i] is a palindrome
            if (isPalindrome(s, index, i)) {
                // If true, add it to the current path
                partition.add(s.substring(index, i + 1));
                 // Recurse for the remaining substring
                getPalindromePartitions(i + 1, partition, ans, s);
                // Backtrack: remove the last added substring from partition
                partition.remove(partition.size() - 1);
            }
        }
    } 
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> partition = new ArrayList<>();
        getPalindromePartitions(0, partition, ans, s);
        return ans;
    }
}