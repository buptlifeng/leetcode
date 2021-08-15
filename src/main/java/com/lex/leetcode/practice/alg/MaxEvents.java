package com.lex.leetcode.practice.alg;

/**
 * https://leetcode-cn.com/problems/maximum-number-of-events-that-can-be-attended/
 * 中等
 *
 * 贪心算法
 * endDay早的会议，提前参加，这样后面还有机会参加endDay晚的会议
 *
 * TODO
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/8/3 下午9:38
 */
public class MaxEvents {

    /**
     * 如果会议持续多天，任选1天参加即可
     * @param events
     * @return
     */
    public int maxEvents(int[][] events) {

        return 0;
    }

    public static void main(String[] args) {
        {
            MaxEvents me = new MaxEvents();
            int[][] events = new int[][]{
                    {1, 2},
                    {2, 3},
                    {3, 4}
            };
            System.out.println(me.maxEvents(events));
        }
    }

}
