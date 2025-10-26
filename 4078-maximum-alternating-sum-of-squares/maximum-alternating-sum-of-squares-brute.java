// Brute

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        // Stores the squares of the nos since negative sign does'nt matter as we need to deal with sum of squares
        // We could use input array too but manipulating input is not a good coding practice
        long[] squares = new long[n];
        // Store the squares into squares array
        for (int k = 0; k < n; k++) {
            squares[k] = (long) nums[k] * nums[k];
        }
        // Sort the squares array
        Arrays.sort(squares);
        // Initialize sum of squares to 0
        long sum = 0;
        // Greedily in each step add the maximum available square and then subtract the minimum available square
        while (i <= j) {
            // When only one element is remaining i.e array is odd, then add that no. to the sum
            if (i == j) {
                sum += squares[i];
                break;
            }
            sum += squares[j--];
            sum -= squares[i++];
        }
        // Return sum
        return sum;
    }
}

// T.C => O(n) + O(n * (log(n)) + O(n / 2) = O(n * log(n))
// S.C => O(n) for the squares array, however tell the interviewer that this can be avoided if we use the input array itself ; which is not a good practice
