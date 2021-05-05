package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 简单
 * 买卖股票的最佳时机 1
 *
 * @author lifeng
 */
public class MaxProfit {

    /**
     * 先找到最小值，然后每天计算最大利润，如果最小值发生变化，保存当前最大利润
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int ans = 0, buy = Integer.MAX_VALUE;
        for (int p : prices) {
            // find min buyin price first
            if (p < buy) {
                buy = p;
            } else if (p - buy > ans) {
                ans = p - buy;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        {
            MaxProfit mp = new MaxProfit();
            int[] prices = new int[]{
                    7, 1, 5, 3, 6, 4
            };
            // 5
            System.out.println(mp.maxProfit(prices));
        }

        {
            MaxProfit mp = new MaxProfit();
            int[] prices = new int[]{
                    7, 6, 4, 3, 1
            };
            // 0
            System.out.println(mp.maxProfit(prices));
        }
    }
}
