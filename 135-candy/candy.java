class Solution {
    public int candy(int[] ratings) {
       int n = ratings.length;
       int i = 1;
       int sum = 1;
       while (i < n) {
        while (i < n && ratings[i] == ratings[i - 1]) {
            sum += 1;
            i++;
        }
        int peak = 1;
        while (i < n && ratings[i] > ratings[i - 1]) {
            peak += 1;
            sum += peak;
            i++;
        }
        int down = 1;
        while (i < n && ratings[i] < ratings[i - 1]) {
            sum += down;
            down++;
            i++;
        } 
        if (down > peak) sum += down - peak;
       }
       return sum;
    }
}