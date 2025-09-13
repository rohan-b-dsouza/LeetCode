// Better (Sliding Window)

class Solution {
    public int totalFruit(int[] fruits) {
       int n = fruits.length;
       int l = 0;
       int r = 0;
       int maxlen = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    while (r < n) {
        map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
        while (map.size() > 2) {
            map.put(fruits[l], map.get(fruits[l]) - 1);
            if (map.get(fruits[l]) == 0) map.remove(fruits[l]);
            l++;
        }
        maxlen = Math.max(r - l + 1, maxlen);
        r++;
    }
    return maxlen;
    }
}

// T.C => O(2 * n)
// S.C => O(1)
