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



// class Solution {
//     public int totalFruit(int[] fruits) {
//         int n = fruits.length;
//         int maxlen = 0;
//         for (int i = 0; i < n; i++) {
//             HashSet<Integer> st = new HashSet<>();
//             for (int j = i; j < n; j++) {
//                 st.add(fruits[j]);
//                 if (st.size() > 2) break;
//                 maxlen = Math.max(j - i + 1, maxlen);
//             }
//         }
//         return maxlen;
//     }
// }