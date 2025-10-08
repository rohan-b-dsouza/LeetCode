// Brute


class Solution {
    public int[] stockSpan(int[] arr, int n) {
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int span = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) break;
                span++;
            }
            ans[i] = span;
        }
        return ans;
    }
}

