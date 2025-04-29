// Better - Solution 

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                list.add(nums1[i++]);
            } else {
                list.add(nums2[j++]);
            }
        }
        while (i < m) {
            list.add(nums1[i++]);
        }
        while (j < n) {
            list.add(nums2[j++]);
        }
        for (i = 0; i < m + n; i++) {
            nums1[i] = list.get(i);
        }
    }
}

// T.C => O(n + m) + O(m + n) = O(2 * (n + m)) = O(m + n) 
// S.C => O(n + m) for the extra list used
