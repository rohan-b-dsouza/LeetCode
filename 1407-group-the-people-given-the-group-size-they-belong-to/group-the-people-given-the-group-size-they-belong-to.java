class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        // <group_size, indices>
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(groupSizes[i], k -> new ArrayList<>()).add(i);
        }
        for (Map.Entry<Integer, List<Integer>> ent : map.entrySet()) {
            int grpsize = ent.getKey();
            List<Integer> indices = ent.getValue();
            while (!indices.isEmpty()) {
                int k = 0;
                List<Integer> temp = new ArrayList<>();
                while (k++ != grpsize) {
                    temp.add(indices.remove(indices.size() - 1));
                }
                ans.add(temp);
            }
        }
        return ans;
     
    }
}