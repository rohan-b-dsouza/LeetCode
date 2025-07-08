// BruteForce - Approach =>

class Solution {
  public void getAllPermutations(
      int index, int n, int[] nums, List<List<Integer>> allPermutations, List<Integer> temp) {
    if (index == n) {
      for (int i = 0; i < n; i++) {
        temp.add(nums[i]);
      }
      allPermutations.add(new ArrayList<>(temp));
      temp.clear();
    }
    for (int i = index; i < n; i++) {
      swap(nums, index, i);
      getAllPermutations(index + 1, n, nums, allPermutations, temp);
      swap(nums, index, i);
    }
  }

  public void swap(int[] nums, int left, int right) {
    int temp = nums[left];
    nums[left] = nums[right];
    nums[right] = temp;
  }

  public void nextPermutation(int[] nums) {
    int original[] = Arrays.copyOf(nums, nums.length);
    int n = nums.length;
    List<List<Integer>> allPermutations = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    getAllPermutations(0, n, nums, allPermutations, temp);
    allPermutations.sort(
        (a, b) -> {
          for (int i = 0; i < a.size(); i++) {
            int cmp = Integer.compare(a.get(i), b.get(i));
            if (cmp != 0) return cmp;
          }
          return 0;
        });
    int ansIdx = -1;
    for (int i = 0; i < allPermutations.size(); i++) {
      boolean flag = false;
      for (int j = 0; j < n; j++) {
        if (original[j] != allPermutations.get(i).get(j)) {
          flag = true;
          break;
        }
      }
      if (!flag) {
        ansIdx = i;
        break;
      }
    }
    if (ansIdx == allPermutations.size() - 1) {
      for (int i = 0; i < n; i++) {
        nums[i] = allPermutations.get(0).get(i);
      }
    } else {
      for (int i = 0; i < n; i++) {
        nums[i] = allPermutations.get(ansIdx + 1).get(i);
      }
    }
  }
}


// T.C => O(N * N!) since total permutations are n! and each is of length n
// S.C => O(N * N!) since an array will be used to store permutations and each is of length n
