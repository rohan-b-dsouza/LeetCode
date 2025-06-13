class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
    int m = arr2.length;
    List<Integer> mergedArr = new ArrayList<>();
    int left = 0;
    int right = 0;
    while (left < n && right < m) {
      if (arr1[left] <= arr2[right]) {
        mergedArr.add(arr1[left]);
        left++;
      } else {
        mergedArr.add(arr2[right]);
        right++;
      }
    }
    while (left < n) {
      mergedArr.add(arr1[left]);
      left++;
    }
    while (right < m) {
      mergedArr.add(arr2[right]);
      right++;
    }
    if ((n + m) % 2 == 1) { // length of list is odd
        return (double) mergedArr.get(((n + m) / 2));
    }
    else {
        return ((double) mergedArr.get((n + m - 1) / 2) + mergedArr.get((n+m) / 2)) / 2;
    }
    }
}


