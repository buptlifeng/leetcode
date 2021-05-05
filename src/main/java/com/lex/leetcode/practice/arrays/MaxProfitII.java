package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 简单
 *
 * @author lifeng
 */
public class MaxProfitII {

    /**
     * 贪心算法
     * 计算每天的差值，然后相加
     * 注意：当天卖出后可以当天买入，题目本身没有限制
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            sum += Math.max(0, prices[i] - prices[i - 1]);
        }
        return sum;
    }

    /**
     * 手里有股票后，不能再次买入，需要卖出后方可买入
     * <p>
     * dp[i][0] 第i天交易后手里没有股票，则(卖出股票获得收入)：
     * dp[i][0]=max{dp[i−1][0],dp[i−1][1]+prices[i]}
     * <p>
     * dp[i][1] 第i天交易后手里有股票，则(买入股票需要花钱)：
     * dp[i][1]=max{dp[i−1][1],dp[i−1][0]-prices[i]}
     *
     * @param prices
     * @return
     */
    public int maxProfitDp(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            // dp[i - 1][1] + prices[i] 表示i-1有股票，但是今天卖掉了，增加的收益就是今日价格
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        {
            MaxProfitII mp = new MaxProfitII();
            int[] prices = new int[]{
                    7, 1, 5, 3, 6, 4
            };
            // 5
            System.out.println(mp.maxProfit(prices));
            System.out.println(mp.maxProfitDp(prices));
        }

        {
            MaxProfitII mp = new MaxProfitII();
            int[] prices = new int[]{
                    1, 2, 3, 4, 5
            };
            // 4
            System.out.println(mp.maxProfit(prices));
            System.out.println(mp.maxProfitDp(prices));
        }

        {
            MaxProfitII mp = new MaxProfitII();
            int[] prices = new int[]{
                    7, 6, 4, 3, 1
            };
            // 0
            System.out.println(mp.maxProfit(prices));
            System.out.println(mp.maxProfitDp(prices));
        }
    }
}
