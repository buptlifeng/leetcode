package com.lex.leetcode.practice.alg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/coin-change-2/
 * 中等
 *
 * @author lifeng
 */
public class CoinChangeII {

    /**
     * 可以认为每种面额硬币有无数个
     * <p>
     * 使用dp思路
     * dp[x] += dp[x - coin]
     * <p>
     * 硬币大小相当于步长
     * 然后以不同的步长，逐步进行计算
     *
     * @param coins  硬币面额
     * @param amount 总额
     * @return
     */
    public int change(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // dp[0]表示目前为0元的方案，只有1种，一枚也不要
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i < amount + 1; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

    /**
     * 递归会产生重复的结果，如：
     * 1，1，1，2
     * 1，1，2，1
     * 1，2，1，1
     * 2，1，1，1
     * 实际上应该算一个结果
     * @param coins
     * @param amount
     * @return
     */
    public int changeRecursion(int[] coins, int amount) {
        LinkedList<Integer> eleList = new LinkedList<>();
        changeHelper(coins, amount, eleList);
        return total;
    }

    int total = 0;

    void changeHelper(int[] coins, int rem, LinkedList<Integer> eleList) {

        if (rem < -1) {
            return;
        }
        if (rem == 0) {
            printList(eleList);
            total++;
            return;
        }

        for (int coin : coins) {
            eleList.offer(coin);
            changeHelper(coins, rem - coin, eleList);
            eleList.removeLast();
        }
    }

    private void printList(LinkedList<Integer> eleList){
        for(Integer ele : eleList){
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        {
            CoinChangeII solution = new CoinChangeII();
            int[] coins = new int[]{
                    1, 2, 5
            };
            // 4
            System.out.println(solution.change(coins, 5));
            System.out.println(solution.changeRecursion(coins, 5));
        }

        {
            CoinChangeII solution = new CoinChangeII();
            int[] coins = new int[]{
                    2
            };
            // 0
            System.out.println(solution.change(coins, 3));
            System.out.println(solution.changeRecursion(coins, 3));
        }

        {
            CoinChangeII solution = new CoinChangeII();
            int[] coins = new int[]{
                    10
            };
            // 1
            System.out.println(solution.change(coins, 10));
            System.out.println(solution.changeRecursion(coins, 10));
        }
    }

}
