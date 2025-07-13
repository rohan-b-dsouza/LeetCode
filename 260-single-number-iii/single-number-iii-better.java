// Better

class Solution {    
    public int[] singleNumber(int[] nums) {        
        int n = nums.length;
        int idx = 0;
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++)  {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                ans[idx++] = key;
            }
        }
        Arrays.sort(ans);
        return ans;
    }
}

// T.C => O(n)
// S.C => O(n)
