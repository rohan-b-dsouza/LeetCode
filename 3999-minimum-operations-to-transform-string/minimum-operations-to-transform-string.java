class Solution {
    public int minOperations(String s) {

        char[] arr = s.toCharArray(); // step 1
        Arrays.sort(arr); // step 2
        String str = new String(arr); // step 3
        int n = s.length();
        int min = 0;
        int lastChar = str.charAt(n - 1);
        if (lastChar == 'a') return 0;
        int operations = 0;
        for (int i = 1; i < n; i++) {
            if (str.charAt(i - 1) == 'a') continue;
            if (str.charAt(i) != str.charAt(i - 1)) {
                operations += str.charAt(i) - str.charAt(i - 1);
            }
        }
        return (operations + ('z' - lastChar + 1));
    }
}