class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b)-> {
            return Integer.compare(b[k], a[k]);
        });
        return score;
    }
}