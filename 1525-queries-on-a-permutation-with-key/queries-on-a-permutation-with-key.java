class Solution {
    public int[] processQueries(int[] queries, int m) {
        int n = queries.length;
        int[] ans = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            list.add(i);
        }
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int curr = queries[i];
            for (int j = 0; j < m; j++) {
                if (list.get(j) == curr) {
                    ans[idx++] = j;
                    list.remove(j);
                    list.addFirst(curr);
                    break;
                }
            }
        }
        return ans;
    }
}