class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        int n = score.length;
        int m = score[0].length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                temp.add(score[i][j]);
            }
            list.add(temp);
        }
        list.sort((a, b)-> {
            return Integer.compare(b.get(k), a.get(k));
        });
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                score[i][j] = list.get(i).get(j);
            }
        }
        return score;

    }
}