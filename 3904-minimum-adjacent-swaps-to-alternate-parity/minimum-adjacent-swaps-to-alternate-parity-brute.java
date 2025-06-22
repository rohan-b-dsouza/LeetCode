// Brute

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int minSwaps = Integer.MAX_VALUE;
        for (int pattern = 0; pattern < 2; pattern++) { // check even - odd pattern and then odd - even pattern
            boolean valid = true; // assuming alternating arrangement is possible 
            int swaps = 0;
            int[] tempNums = nums.clone();
            for (int i = 0; i < n; i++) {
                int expectedParity = i % 2 == 0 ? pattern : 1 - pattern;
                if (tempNums[i] % 2 != expectedParity) {
                    int j = i + 1;
                    while (j < n && (tempNums[j] % 2 != expectedParity)) {
                        j++;
                    }
                    if (j == n) {
                        valid = false;
                        break;
                    }
                    while (j > i) {
                        int temp = tempNums[j];
                        tempNums[j] = tempNums[j - 1];
                        tempNums[j - 1] = temp;
                        swaps++;
                        j--;
                    }
                }
            }
            if (valid) minSwaps = Math.min(minSwaps, swaps);
        }
        return minSwaps == Integer.MAX_VALUE ? -1 : minSwaps; 
    }
}

// T.C => O(n^2)
// S.C => O()
