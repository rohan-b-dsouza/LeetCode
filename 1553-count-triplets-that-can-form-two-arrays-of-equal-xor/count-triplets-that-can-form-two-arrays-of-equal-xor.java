class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> count = new HashMap<>(), total = new HashMap<>();
        int xor = 0;
        int ans = 0;
        count.put(0, 1);
        total.put(0, 0);
        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
            if (count.containsKey(xor)) {
                ans += count.get(xor) * i - total.get(xor);
            }

            count.put(xor, count.getOrDefault(xor, 0) + 1);
            total.put(xor, total.getOrDefault(xor, 0) + i + 1);
        }
        return ans;
    }
}