// Optimal

/* Logic:- 
    First we set a top, now since left depends on top we assign a left using the given rules.
    Now, since right also depends on top, we assign right using the given rules. 
    Now, finally since bottom depends on both left and right, we assign it using the given rules.
    We use 4 nested loops for this to ensure we cover all possible combinations.

    Now, once all distinct words squares are stored in the list, we sort it lexicographically 
*/
class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ans = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            String top = words[i];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                String left = words[j];
                if (left.charAt(0) != top.charAt(0)) continue;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    String right = words[k];
                    if (right.charAt(0) != top.charAt(3)) continue;
                    for (int l = 0; l < n; l++) {
                        if (l == i || l == j || l == k) continue;
                        String bottom = words[l];
                        if (bottom.charAt(0) != left.charAt(3) || bottom.charAt(3) != right.charAt(3)) continue;
                        List<String> temp = Arrays.asList(top, left, right, bottom);
                        ans.add(temp);
                    }
                }
            }
        }
        ans.sort((a, b)->{
            for (int i = 0; i < 4; i++) {
                int cmp = a.get(i).compareTo(b.get(i));
                if (cmp != 0) return cmp;
            }
            return 0;
        });
        return ans;
    }
}

// T.C => O(n ^ 4) 
// S.C => O(1)
