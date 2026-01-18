class Solution {
    public long minimumCost(String s, String t, int flipCost, int swapCost, int crossCost) {
        int n = s.length();
        long cost = 0;
        int flip1 = 0;
        int flip2 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0' && t.charAt(i) == '1') flip1++;
            else if (s.charAt(i) == '1' && t.charAt(i) == '0') flip2++; 
        }
        int min = Math.min(flip1, flip2);
        int max = Math.max(flip1, flip2);
        cost += Math.min(1L * min * swapCost, 2L * min * flipCost);
        max = max - min;
        cost += Math.min(1L * (max / 2) * (swapCost + crossCost), 2L * (max / 2) * flipCost);
        if (max % 2 == 1) cost += flipCost;
        return cost;
    }
}