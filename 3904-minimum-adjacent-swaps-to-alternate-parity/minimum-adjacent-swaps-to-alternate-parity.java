class Solution {
    public int noOfSwaps(List<Integer> arr) {
        int swaps = 0;
        for (int i = 0; i < arr.size(); i++) {
            swaps += Math.abs(arr.get(i) - 2 * i);
        }
        return swaps;
    }
    public int minSwaps(int[] nums) {
        List <Integer> even = new ArrayList<>();
        List <Integer> odd = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) even.add(i);
            else odd.add(i);
        }
        if (Math.abs(even.size() - odd.size()) > 1) return -1; // If array length is even, you need equal even == odd
        // If array length is odd, you need the difference to be exactly 1 (|even - odd| == 1)
        // If the difference is more than 1 — i.e., one type occurs much more — then you can’t alternate    without placing two same-parity elements next to each other.
        int ans = Integer.MAX_VALUE;
        if (even.size() >= odd.size()) { 
            ans = Math.min(ans, noOfSwaps(even));
        }
        if (odd.size() >= even.size()) {
            ans = Math.min(ans, noOfSwaps(odd));
        }
        return ans;
    }
}

// T.C => O(n) 
// S.C => O(n) for extra 2 arrays