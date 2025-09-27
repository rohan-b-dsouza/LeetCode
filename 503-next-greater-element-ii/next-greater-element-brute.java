// Brute

class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
          // First mark current element's NGE as -1
          ans[i] = -1;
          // Go upto i + n to circularly wrap around the array
            for (int j = i + 1; j < i + n ; j++) {
              // Get actual index using modulo n
                int idx = j % n;
              // If we find an element greater than current element, its NGE of current element hence store it and break
                if (arr[idx] > arr[i]) {
                    ans[i] = arr[idx];
                    break;
                }
            }
        }
      // Return ans
        return ans;
    }
}

// T.C => O(n ^ 2)
// S.C => O(n)
