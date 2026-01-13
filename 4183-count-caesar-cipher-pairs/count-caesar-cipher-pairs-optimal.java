// Optimal

// Logic:- Normalize each string to such that each string starts from a. Hence, characters are shifted backwards such that first character of each string becomes 'a'. 
// The map stores the frequency of the new normalized strings and accordingly the similar pairs are computed.

class Solution {
    public long countPairs(String[] words) {
        int n = words.length;
        long ans = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            StringBuilder sb = new StringBuilder();
            char base = str.charAt(0);
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                sb.append((char)(ch - base + 26) % 26 + 'a');
            }
            String transform = sb.toString();
            ans += map.getOrDefault(transform, 0);
            map.merge(transform, 1, Integer::sum);
        }
    return ans;
    }
}

// T.C => O(n * m)
// S.C => O(n)

