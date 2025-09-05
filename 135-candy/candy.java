// Bruteforce

class Solution {
    public int candy(int[] ratings) {
       int n = ratings.length;
       int[] left = new int[n];
       int[] right = new int[n];
       left[0] = 1;
       right[n - 1] = 1;
        // Step 1 : Give candies by considering only the left neighbour
       for (int i = 1; i < n; i++) {
        if (ratings[i] > ratings[i - 1]) {
            left[i] = left[i - 1] + 1;
        }
        else {
            left[i] = 1;
        }
       }
        // Step 2 : Give candies by considering only the right neighbour
       for (int i = n - 2; i >= 0; i--) {
        if (ratings[i] > ratings[i + 1]) {
            right[i] = right[i + 1] + 1;
        }
        else {
            right[i] = 1;
        }
       }
       int sum = 0;
        // Sum the candies by taking max of left and right 
       for (int i = 0; i < n; i++) {
        sum += Math.max(left[i], right[i]);
       }
        // Return the minimum required candies
       return sum;
    }
}

// T.C => O(3 * n) = O(n)
// S.C => O(2 * n) = O(n) for the two extra arrays 'left' and 'right' 
