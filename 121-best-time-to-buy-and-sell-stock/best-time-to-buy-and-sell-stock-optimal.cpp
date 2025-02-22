// Optimal - Approach =>

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minbuy = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.size(); i++) {
            minbuy = min(minbuy, prices[i]);
            maxProfit = max(maxProfit, prices[i] - minbuy);
        }
        return maxProfit;
    }
};

// Time Complexity :- O(n)
// Space Complexity :- O(1)
