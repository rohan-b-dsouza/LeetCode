// Brute-Force =>

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> majorityElement = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            int num = nums[i];
            if (majorityElement.empty() || majorityElement.get(0) != num) { // check if num is a majority element only if its not already in the majorityElement list.
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == num) {
                        cnt++;
                    }
                }
                if (cnt > (nums.length / 3)) {
                    majorityElement.add(num);
                }
            }

        }
        return majorityElement;
    }
}

// T.C => O(n^2)
// S.C => O(2) => O(1)
