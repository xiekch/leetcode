class Solution {
    public int maxProfit(int[] prices) {
        // [][0] for buy, [][1] for sell
        if (prices.length <= 1)
            return 0;
        int ans = 0;
        int[][] dp = new int[prices.length][2];

        for (int i = 1; i < prices.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i][1] = Integer.max(dp[i][1], dp[j][0] + prices[i] - prices[j]);
                if (j <= i - 2)
                    dp[i][0] = Integer.max(dp[i][0], dp[j][1]);
            }
            ans = Integer.max(ans, Integer.max(dp[i][1], dp[i][0]));
        }

        return ans;
    }
}

class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] testset = { { 1, 2, 3, 0, 2 }, { 1, 2, 1, 100, 1, 2, 3 } };
        for (int[] prices : testset)
            System.out.println(sol.maxProfit(prices));
    }
}