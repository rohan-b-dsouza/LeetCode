class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int minbuy = INT_MAX;
        int maxProfit = 0;
        for (int i = 0; i < prices.size(); i++) {
            if (prices[i] < minbuy) {
                minbuy = prices[i];
            }
            else {
                maxProfit = max(maxProfit, prices[i] - minbuy);
            }
        }
        return maxProfit;
    }
};