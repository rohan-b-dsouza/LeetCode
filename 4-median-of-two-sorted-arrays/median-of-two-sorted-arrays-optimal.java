// Optimal

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        while (n1 > n2)
            return findMedianSortedArrays(nums2, nums1); // for better T.C we want first array to be of smaller size
        int n = n1 + n2;
        int low = 0;
        int high = n1;
        int left = (n1 + n2 + 1) / 2;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            int l1 = (mid1 > 0) ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? nums1[mid1] : Integer.MAX_VALUE;
            int l2 = (mid2 > 0) ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int r2 = (mid2 < n2) ? nums2[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) { // we got the required symmetry
                if (n % 2 == 0)
                    return (((double) Math.max(l1, l2) + Math.min(r1, r2)) / 2);
                return (double) Math.max(l1, l2);
            } else if (l1 > r2)
                high = mid1 - 1; // Eliminate the right half of nums1
            else
                low = mid1 + 1; // Eliminate the left half of nums1
        }
        return 0;
    }
}

// T.C => O(log (min (n1, n2)))
// S.C => O(1)
