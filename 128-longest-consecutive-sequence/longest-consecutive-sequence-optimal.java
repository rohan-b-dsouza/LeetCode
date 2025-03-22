// Optimal - Solution =>

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet <Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int maxcnt = 1;
        for (int num : set) {
            int cnt = 1;
            if (set.contains(num - 1) == true) {
                continue;
            }
            else {
                int x = num;
                while(set.contains(x + 1) == true) {
                    cnt++;
                    x++;
                }
                maxcnt = Math.max(maxcnt, cnt); 
            }
        }
        return maxcnt;
    }
}
// T.C => O(n) + O(2n) = O(3n) = O(n) ...{For the best and average case}
// Note:- However, if the worst case can occur due to collisions then its better to use the 'Better' solution as using 
// ordered set(TreeSet) will also be inefficient}

// S.C => O(n)
