// Optimal

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        // List to store the answer
        List<Integer> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // HashSet for fast lookups
        HashSet<Integer> set = new HashSet<>();
        // Get the min and max elements of the array, also add all the elements to the HashSet
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }
        // Iterate from min to max as elements are in the range [min, max]
        // Check if element is present in the set, if not then add it to the answer list
        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }
        // Return ans
        return ans;
    }
}

// T.C => O(n) + O(max - min + 1) = O(max - min + 1)
// S.C => O(n) for the HashSet
