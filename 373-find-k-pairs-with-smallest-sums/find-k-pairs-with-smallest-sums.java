class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) return ans;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]])
        );

        // initial push
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            pq.add(new int[]{i, 0});
        }

        while (k-- > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[0];
            int j = curr[1];

            ans.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {
                pq.add(new int[]{i, j + 1});
            }
        }

        return ans;
    }
}