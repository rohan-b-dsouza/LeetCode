class Solution {
    public int minOperations(int n) {
        int i = 1; int j = 2 * (n - 1) + 1;
        int sum = 0;
        while (i < j) {
            sum += (j - i);
            j -= 2; i += 2;
        }
        return sum / 2;
        
    }
}