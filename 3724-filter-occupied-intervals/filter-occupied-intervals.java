class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
        Arrays.sort(occupiedIntervals, (a, b) -> {
            int compare = Integer.compare(a[0], b[0]);
            if (compare != 0)
                return compare;
            else
                return Integer.compare(a[1], b[1]);
        });

        List<int[]> merged = new ArrayList<>();
        merged.add(occupiedIntervals[0]);

        for (int i = 1; i < occupiedIntervals.length; i++) {
            int[] interval = occupiedIntervals[i];
            int[] lastInterval = merged.get(merged.size() - 1);

            if (interval[0] <= lastInterval[1]) {
                merged.remove(merged.size() - 1);
                merged.add(new int[] { lastInterval[0], Math.max(lastInterval[1], interval[1]) });
            } else if (interval[0] == lastInterval[1] + 1) {
                merged.remove(merged.size() - 1);
                merged.add(new int[] { lastInterval[0], interval[1] });
            } else {
                merged.add(occupiedIntervals[i]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int[] arr : merged) {
            if (freeEnd < arr[0] || freeStart > arr[1]) {
                ans.add(new ArrayList<>(Arrays.asList(arr[0], arr[1])));
            } else if (freeStart <= arr[0] && freeEnd < arr[1]) {
                ans.add(new ArrayList<>(Arrays.asList(freeEnd + 1, arr[1])));
            } else if (freeStart > arr[0] && freeEnd < arr[1]) {
                ans.add(new ArrayList<>(Arrays.asList(arr[0], freeStart - 1)));
                ans.add(new ArrayList<>(Arrays.asList(freeEnd + 1, arr[1])));
            } else if (freeStart > arr[0] && freeEnd >= arr[1]) {
                ans.add(new ArrayList<>(Arrays.asList(arr[0], freeStart - 1)));
            }
        }
        return ans;
    }
}