class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> ans = new ArrayList<>();
        int[][] arr = new int[26][2];
        for (int i = 0; i < 26; i++) {
            arr[i][0] = n;
            arr[i][1] = n;
        }
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (arr[idx][0] == n) {
                arr[idx][0] = i;
                arr[idx][1] = i;
            } 
            else {
                arr[idx][1] = i;
            }
        }
        int i = 0;
        int firstIdx = -1; int lastIdx = -1;
        while (i < n) {
            int[] range = arr[s.charAt(i) - 'a']; 
            System.out.println(firstIdx + " " + lastIdx);
            if (range[1] == lastIdx && lastIdx == i) {
                ans.add(lastIdx - firstIdx + 1);
                firstIdx = -1;
                lastIdx = -1;
                i++;
                continue;
            }
            if (firstIdx == -1) {
                firstIdx = range[0];
            }
            lastIdx = Math.max(lastIdx, range[1]);
            if (lastIdx == firstIdx) {
                ans.add(1);
                firstIdx = -1;
                lastIdx = -1;
            }

            i++;
        }
        return ans;
    }
}