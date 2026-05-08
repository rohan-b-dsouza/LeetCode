class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int xor = 0;
            for (int j = i; j < n; j++) {
                xor ^= arr[j];
                if (xor == 0) ans += j - i;
            }
        }
        return ans;
    }
}