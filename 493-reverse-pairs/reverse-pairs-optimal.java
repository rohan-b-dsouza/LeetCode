// Optimal - Solution (Merge Sort)

class Solution {
    static int countPairs(int arr[], int low, int mid, int high) {
        int cnt = 0;
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && arr[i] > 2 * (long)arr[j]) {
                j++;
            }
            cnt += j - (mid + 1);
        }
        return cnt;
    }
    static void merge(int arr[], int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        List<Integer> list = new ArrayList<>();
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                list.add(arr[left]);
                left++;
            }
            else {
                list.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            list.add(arr[left]);
            left++;
        }
        while (right <= high) {
            list.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = list.get(i - low);
        }    
    }    

    static int mergeSort(int arr[], int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid + 1, high);
        cnt += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);   
        return cnt;
    }

    public int reversePairs(int[] nums) {
        int cnt = 0;
        cnt = mergeSort(nums, 0, nums.length - 1);
        return cnt;
    }
}

// T.C => O(logn * (n + n)) = O(2* n * log(n)) -------------------{Explanation in notebook}
// S.C => O(n) for the extra list
