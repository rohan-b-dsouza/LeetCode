// Optimal Approach (Greedy)
// Watch video to understand intuition (Highly - non intuitive solution)

class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int min = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            // If its a '(' increment both min and max
            if (s.charAt(i) == '(') {
                min++;
                max++;
            }
            // If its a ')' decrement both min and max
            else if (s.charAt(i) == ')') {
                min--;
                max--;
            }
            // If its a '*' take the range of values i.e [min, max] 
            else {
                min--;
                max++;
            }   
            // If min becomes -1 make it 0 as we dont want -1 as this denoted invalid string
            if (min < 0) min = 0;
            // If max becomes -1, it means valid string is not possible as there is a clear imbalance
            if (max < 0) return false;
        }
        // If min is zero at last return true as it denotes there exists some path s.t valid string is possible
        return min == 0;
    }
}

// T.C => O(n)
// S.C => O(1)
