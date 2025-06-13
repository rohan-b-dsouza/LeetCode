class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int n = n1 + n2;
        int i = 0;
        int j = 0;
        int first_elem = -1;
        int second_elem = -1;
        int cnt = 0;
        int idx2 = n / 2;
        int idx1 = (n / 2) - 1;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                if (cnt == idx1)
                    first_elem = arr1[i];
                if (cnt == idx2)
                    second_elem = arr1[i];
                cnt++;
                i++;
            } else {
                if (cnt == idx1)
                    first_elem = arr2[j];
                if (cnt == idx2)
                    second_elem = arr2[j];
                cnt++;
                j++;
            }
        }
        while (i < n1) {
            if (cnt == idx1)
                first_elem = arr1[i];
            if (cnt == idx2)
                second_elem = arr1[i];
            cnt++;
            i++;
        }
        while (j < n2) {
            if (cnt == idx1)
                first_elem = arr2[j];
            if (cnt == idx2)
                second_elem = arr2[j];
            cnt++;
            j++;
        }
        if (n % 2 == 0)
            return (((double) first_elem + second_elem) / 2);
        return (double) second_elem;
    }
}