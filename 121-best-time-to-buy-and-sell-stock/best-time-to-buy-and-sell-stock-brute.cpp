// Brute-Force Approach =>

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[j] > prices[i]) {
                    maxProfit = max(maxProfit, prices[j] - prices[i]);
                } 
            }
        }
        return maxProfit;
    }

};

// Time complexity: O(n^2)
// Space Complexity: O(1)
