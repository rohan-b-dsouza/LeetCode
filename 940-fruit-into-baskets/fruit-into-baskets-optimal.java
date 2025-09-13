// Optimal (Sliding Window)

class Solution {
    public int totalFruit(int[] fruits) {
       int n = fruits.length;
       int l = 0;
       int r = 0;
       int maxlen = 0;
        // HashMap to store the fruit type and its frequency of occurence
    HashMap<Integer, Integer> map = new HashMap<>();
    while (r < n) {
        // Put the current fruit in the map and update its frequency if already exists
        map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
        // If map size goes beyond 2, shrink the window only by 1 to limit the window size to maxlen encountered so far, and try to find a larger valid window in next iteration
        if (map.size() > 2) {
            // Remove the fruit at 'l' by updating its frequency in the map
            map.put(fruits[l], map.get(fruits[l]) - 1);
            // If a fruit's freq becomes 0 remove it from the map
            if (map.get(fruits[l]) == 0) map.remove(fruits[l]);
            // Increment left pointer 'l' in each step
            l++;
        }
        // Update maxlen
        maxlen = Math.max(r - l + 1, maxlen);
        // Expand the window using 'r' pointer
        r++;
    }
    // Return maxlen
    return maxlen;
    }
}

// T.C => O(n)
// S.C => O(1)
