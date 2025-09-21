// Optimal

class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        // Use a TreeSet in descending order to store distinct numbers
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int num : nums) {
            set.add(num);
        }
        
        // Prepare the result array with at most k elements
        int size = Math.min(k, set.size());
        int[] res = new int[size];
        int idx = 0;
        for (int num : set) {
            if (idx == size) break;
            res[idx++] = num;
        }
        return res;
    }
}

// T.C => O(n * log(n)) + O(min(k, set.size())
// S.C => O(n) + O(min(k, set.size())
