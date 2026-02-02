class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->{
            int compare =  Integer.compare(map.get(a), map.get(b));
            if (compare != 0) return compare;
            return Integer.compare(a, b);
        });
        for (int key: map.keySet()) {
            pq.offer(key);
            if (pq.size() > k) pq.poll();
        }
        int it = k - 1;
        while(!pq.isEmpty()) {
            ans[it--] = pq.poll();
        }
        return ans;
    }
}