// Optimal

class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        // Get the maximum sum of the range 1 to n
        long sum = 1L * n * (n + 1) / 2;
        // Array to store the answer
        int[] res = new int[n];
        // 'st' is used to put smaller numbers from the left, and 'en' to put greater numbers from the right
        int st = 0;
        int en = n - 1; 
        // If sum & target do not have the same parity and target is greater than sum, return an empty array
        if ((((sum + target) % 2) != 0) || (Math.abs(target) > sum)) return new int[0];
        // Iterate from largest to smallest, so that we can assign as small number (-ve) as possible to the left, to get lexicographically smaller number 
        for (int i = n; i >= 1; i--) {
            // If we assign the current number a negative sign & if it's still possible to achieve the newTarget = target + i, then assign a negative sign & put it in res
            if ((target + i) <= (1L * i * (i - 1)) / 2) {
                target += i;
                res[st++] = -i;
            }
            // Else assign a positive sign, and subtract it from the target and put it in res assigning it a positive sign
            else {
                target -= i;
                res[en--] = i;
            }
        }
        // Return res
        return res;
    }
}

// T.C => O(n)
// S.C => O(1)
