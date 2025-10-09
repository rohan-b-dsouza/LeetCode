// Brute 
// VVIMP : Refer the GFG Problem 'The Celebrity Problem' in which the input is given in a different way; but it changes the solutions significantly, so its very important to solve that problem too.

class Solution {
    public int findJudge(int n, int[][] trust) {
        // Array that tracks how many people trust a person
        int[] trustsMe = new int[n + 1];
        // Array that tracks how many people a person trusts
        int[] Itrust = new int[n + 1];
        // Iterate over the entire array and set the above two arrays
        for (int[] t : trust) {
            int a = t[0];
            int b = t[1];
            Itrust[a]++;
            trustsMe[b]++;
        }
        for (int j = 1; j <= n; j++) {
            // For each person check if its trusted by all other people (i.e n - 1) and also check if it doesn't trust anyone else. If so then this is the celebrity
            if (trustsMe[j] == n - 1 && Itrust[j] == 0) {
                return j;
            }
        }
        return -1;
    }

}

// T.C => O(n) + O(n) = O(2 * n) = O(n)
// S.C => O(2 * n) = O(n)
