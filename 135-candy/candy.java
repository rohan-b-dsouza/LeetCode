class Solution {
    // To calculate number of candies
    public int candy(int[] ratings) {
        // Get number of children
        int n = ratings.length;
        // If no children, return 0
        if (n == 0) return 0;

        /*Initialize arrays to store candies
        for each child from left and right*/
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        /*Left to right pass
        Traverse the ratings from left to right
        to adjust candies based on ratings*/
        for (int i = 1; i < n; ++i) {
            /*If the current child's rating is
            higher than the previous one*/
            if (ratings[i] > ratings[i - 1]) {
                /*Give the current child one
                more candy than the previous one*/
                left[i] = left[i - 1] + 1;
            }
        }

        /*Right to left pass
        Traverse the ratings from right to left
        to adjust candies based on ratings*/
        for (int i = n - 2; i >= 0; --i) {
            /*If the current child's rating is
            higher than the next one*/
            if (ratings[i] > ratings[i + 1]) {
                /*Give the current child one
                more candy than the next one*/
                right[i] = right[i + 1] + 1;
            }
        }

        /*Combine results
        Calculate the total number of candies
        needed by taking the maximum from
        left and right for each child*/
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            /*Each child gets the maximum
            candies from left and right*/
            ans += Math.max(left[i], right[i]);
        }
        // Return total
        return ans;
    }
}