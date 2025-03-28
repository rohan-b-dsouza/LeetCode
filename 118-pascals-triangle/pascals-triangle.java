class Solution {
    public int ncr(int r, int c) {
        long curr = 1;
        for (int j = 0; j < c; j++) {
            curr = (curr * (r - j)) / (j + 1);
        }
        return (int) curr;
    }
    public List<List<Integer>> generate(int numRows) {
        List <List<Integer>> listoflists = new ArrayList<>();
        for (int r = 1; r <= numRows; r++) {
            List<Integer> tempList = new ArrayList<>();
            for (int c = 1; c <= r; c++) {
                tempList.add(ncr(r - 1, c - 1));     
            }
            listoflists.add(tempList);
        }
        return listoflists;
    }
}