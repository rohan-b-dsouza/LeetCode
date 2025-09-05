// Better

class Solution {
    public int candy(int[] ratings) {
       int n = ratings.length;
       int[] left = new int[n];
       left[0] = 1;
        // Step 1 : Give candies considering only the left neighbours
       for (int i = 1; i < n; i++) {
           // If rating is higher than left neighbour, give one candy more than left neighbour
        if (ratings[i] > ratings[i - 1]) {
            left[i] = left[i - 1] + 1;
        }
            // Else give only one candy
        else {
            left[i] = 1;
        }
       }
       int sum = left[n - 1];
       int rightCandies = 1;
        // Simulate the process of taking candies by considering right neighbours like in brute force but use a variable rightCandies instead of right array, simultaneously accumulating the sum
       for (int i = n - 2; i >= 0; i--) {
        if (ratings[i] > ratings[i + 1]) {
            // If rating is higher than right neighbour, add a candie to rightCandies
            rightCandies = rightCandies + 1;        
            // Add max of rightCandies and left[i] to the sum
            sum += Math.max(rightCandies, left[i]);
            }
            // If rating is lower than right neighbour, reset rightCandies to 1
        else {
            rightCandies = 1;
            // Add left[i] to sum as we need max of left and rightCandies and at minimum left[i] can be 1 
            sum += left[i];
        }
       }
        // Return the minimum required candies
       return sum;
    }
}

// T.C => O(2 * n) = O(n)
// S.C => O(n) for the array 'left'

