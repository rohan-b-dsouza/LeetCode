// Brute (Approach : Simulation)

class Solution {
    public int minOperations(String s) {
        // Sort the characters in the string 
        // Since strings are immutable in java we need to use an array of characters
        // to sort the string
        char[] arr = s.toCharArray(); // step 1
        Arrays.sort(arr); 
        String str = new String(arr); 
        int n = s.length();
        // Store the last character to count no. of operations reqd to convert last character to 'a'
        char lastChar = str.charAt(n - 1);
        // If last char is a it clearly means no operations are reqd on the string as all chars are 'a'
        if (lastChar == 'a') return 0;
        // Initialize operations to 0
        int operations = 0;
        // Traverse the string
        for (int i = 1; i < n; i++) {
            // If previous character is 'a' then skip this iteration as 'a' does'nt have to be converted 
            if (str.charAt(i - 1) == 'a') continue;
            // If current character is not equal to previous, then calculate the no. of operations reqd to convert prev character to current character and add it to operations
            if (str.charAt(i) != str.charAt(i - 1)) {
                operations += str.charAt(i) - str.charAt(i - 1);
            }
        }
        // This is reqd to convert last character to 'a'
        // Note :- If last character is 'z' then 'z' - 'z' = 0 hence, it adds one to the operations
        // If last character is not 'z' then it calculates no. of operations reqd to convert last character to 'z' and adds 1 to it as the now 'z' also has to be converted to 'a'.
        return (operations + ('z' - lastChar + 1));
    }
}