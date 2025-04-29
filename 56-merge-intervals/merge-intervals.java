class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (list.isEmpty() || start > list.get(list.size() - 1).get(1)) {
                list.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            }
            else {
                List <Integer> lastinterval = list.get(list.size() - 1);
                lastinterval.set(1, Math.max(lastinterval.get(1), end));
            }
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i][0] = list.get(i).get(0);
            ans[i][1] = list.get(i).get(1);
        }
        return ans;
    }
}