// Brute

class Solution {
    public boolean canWePlace(int[] nums, int dist, int cows) {
        
        int n = nums.length;

       
        int cntCows = 1;

     
        int last = nums[0];
        
        for (int i = 1; i < n; i++) {
            if (nums[i] - last >= dist) {
                cntCows++;

                last = nums[i];
            }
            if (cntCows >= cows) return true;
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);

        int limit = position[n - 1] - position[0];
        for (int i = 1; i <= limit; i++) {
            if (!canWePlace(position, i, m)) {
                return (i - 1);
            }
        }
        return limit;
    }
}

// T.C => O(n * log(n)) + O(n * (max - min))
// S.C => O(1)
