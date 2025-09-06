// Optimal (Greedy) (Peak & Valley)

class Solution {
    public int candy(int[] ratings) {
       int n = ratings.length;
       int i = 1;
       int sum = 1;
        // Loop till n is reached 
       while (i < n) {
           // If its a flat line, just give one candies
        while (i < n && ratings[i] == ratings[i - 1]) {
            sum += 1;
            i++;
        }
           // Assign peak as 1
        int peak = 1;
           // If its an incline, increment peak by 1 and add peak to sum
        while (i < n && ratings[i] > ratings[i - 1]) {
            peak += 1;
            sum += peak;
            i++;
        }
           // Assign peak as 1
        int down = 1;
           // If its a decline (valley), add down to sum and increment down by 1
        while (i < n && ratings[i] < ratings[i - 1]) {
            sum += down;
            down++;
            i++;
        } 
           // If down > peak, it means that the previous peak should be incremented by down - peak (This is reqd as we are not distributing candies in reverse manner for decline (valley))
        if (down > peak) sum += down - peak;
       }
       return sum;
    }
}

// T.C => O(n) 
// S.C => O(1)
