package com.lex.leetcode.practice.alg;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * 中等
 *
 * @author lifeng
 */
public class CoinChange {

    /**
     * dp思路
     * F[i]是凑成i所需要的最少硬币数
     * 则:
     * F[i] = min{F[i-c],c代表可选硬币的面值} + 1
     * 例如：
     * coins={1,2,5}，则F[6]=min{F[5],F[4],F[1]} + 1
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChangeDp(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        // 先将dp初始化为最大值
        for (int i = 1; i < max; i++) {
            dp[i] = max;
        }
        dp[0] = 0;
        for (int i = 1; i < max; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }

        return coinChange(coins, amount, new int[amount]);
    }

    int coinChange(int[] coins, int amount, int[] mem) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (mem[amount - 1] != 0) {
            return mem[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int rem = coinChange(coins, amount - coin, mem);
            if (rem >= 0 && rem < min) {
                min = 1 + rem;
            }
        }
        mem[amount - 1] = min != Integer.MAX_VALUE ? min : -1;
        return mem[amount - 1];
    }

    public static void main(String[] args) {
        {
            CoinChange solution = new CoinChange();
            int[] coins = new int[]{
                    1, 2, 5
            };
            // 3
            System.out.println(solution.coinChange(coins, 11));
            System.out.println(solution.coinChangeDp(coins, 11));
        }

        {
            CoinChange solution = new CoinChange();
            int[] coins = new int[]{
                    2
            };
            // -1
            System.out.println(solution.coinChange(coins, 3));
            System.out.println(solution.coinChangeDp(coins, 3));
        }

        {
            CoinChange solution = new CoinChange();
            int[] coins = new int[]{
                    1
            };
            // 0
            System.out.println(solution.coinChange(coins, 0));
            System.out.println(solution.coinChangeDp(coins, 0));
        }
    }
}
