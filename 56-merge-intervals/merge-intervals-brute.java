// Brute-Approach =>

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List <List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) continue;
            for (int j = i + 1; j < n; j++) {
                if (intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                }
                else {
                    break;
                }
            }
            
            ans.add(Arrays.asList(start, end););
        }
        int [][] finalans = new int[ans.size()][2];a
        for (int i = 0; i < ans.size(); i++) {
            finalans[i][0] = ans.get(i).get(0);
            finalans[i][1] = ans.get(i).get(1);
        }
        return finalans;
    }
}

// T.C => O(nlogn) + O(n^2) = O(n^2) -----------------{we dont consider the last for loop as its required to return the ans not to solve it}
// S.C => O(2n) ------------But here both the list 'ans' and array 'finalans' are not required for solving the question but to store and return the ans therefore S.C can be considered as O(1)
