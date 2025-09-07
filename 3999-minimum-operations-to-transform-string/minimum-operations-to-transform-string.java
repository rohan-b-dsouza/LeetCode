class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int minOperations = 0;
        for (int i = 0; i < n; i++) {
            // Retrieve the current character from the string
            char ch = s.charAt(i);
            // Compute the no. of operations reqd to transform this character to 'a'  
            // Note :- % 26 is required only to handle the edge case where the curr char is 'a' 
            // Due to % 26 the the instance where we get a is computed as 0 to avoid errors
            int dist = (26 - (ch - 'a')) % 26;
            // Store the max dist seen so far, this is imp to ensure that we store the no. of operations 
            // reqd to convert the smallest char in the string to 'a'
            minOperations = Math.max(minOperations, dist);
        }
        return minOperations;
    }
}

// NOTE :- The minimum no. of operations is equal to no. of operations reqd to transform the smallest character in the string to 'a'. This is because as we saw in brute we convert each character in sorted order to next character in order eventually converting last character to 'a'. Hence, this will be same as converting smallest one to 'a'

// T.C => O(n)
// S.C => O(1)
