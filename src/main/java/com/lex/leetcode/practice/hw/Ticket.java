package com.lex.leetcode.practice.hw;

import java.util.HashMap;
import java.util.Map;

/**
 * 排队领票
 * 1.只能领取该时间点的票，该时间点没有领完，余票废弃
 * 2.先到人可以排队等候放票时间点发票
 * 3.1人1票
 * 4.本轮没领到票，可以等下一轮
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/6/2 下午10:48
 */
public class Ticket {

    /**
     * @param a 用户到达时间点 可以认为是有序的
     * @param b 发票时间点
     * @param n 每轮发票的票数
     * @return
     */
    public int lastTicket(int[] a, int[] b, int n) {
        // 模拟法
        int blen = b.length;
        // 如果第一个人都晚于最晚发票时间点到来
        if (a[0] > b[blen - 1]) {
            return b[blen - 1];
        }
        int total = n * blen;
        Map<Integer, Integer> ticketMap = new HashMap<>();
        for (int i = 0; i < blen; i++) {
            ticketMap.put(b[i], n);
        }

        // 默认值：早于第一个人到达时间即可
        int ans = a[0] - 1;
        int k = 0, j = 0;
        for (; j < a.length && k < blen; j++) {
            // 计算当前时刻是否大于派发时刻
            int comeTime = a[j];
            for (; k < blen; k++) {
                int cc = ticketMap.getOrDefault(b[k], 0);
                // 来晚了，这一轮没票，看下一轮
                if (comeTime > b[k] || cc == 0) {
                    total -= cc;
                    // 重置为0
                    ticketMap.put(b[k], 0);
                    continue;
                }
                // 正常发票
                ticketMap.put(b[k], cc - 1);
                total--;
                // 实时判断余票
                if (total == 0) {
                    return comeTime - 1;
                }
                // 每个用户领一张票即可
                break;
            }
        }
        // 此处分别对应2种情况：一种是票数富余，一种是观众都来晚了（没票）
        return total > 0 ? b[k] : ans;
    }

    public static void main(String[] args) {

        {
            Ticket ticket = new Ticket();
            int[] a = new int[]{
                    11, 12, 15, 15, 15
            };
            int[] b = new int[]{
                    6, 8
            };
            // 8
            System.out.println(ticket.lastTicket(a, b, 2));
        }

        {
            Ticket ticket = new Ticket();
            int[] a = new int[]{
                    11, 12, 15, 15, 15
            };
            int[] b = new int[]{
                    17, 18
            };
            // 18 票数足够
            System.out.println(ticket.lastTicket(a, b, 3));
        }

        {
            Ticket ticket = new Ticket();
            int[] a = new int[]{
                    11, 12, 15, 15, 15
            };
            int[] b = new int[]{
                    17, 18, 19
            };
            // 18 票数足够
            System.out.println(ticket.lastTicket(a, b, 3));
        }

        {
            Ticket ticket = new Ticket();
            int[] a = new int[]{
                    11, 12, 15, 15, 15
            };
            int[] b = new int[]{
                    15, 16
            };
            // 11 票数不够
            System.out.println(ticket.lastTicket(a, b, 1));
        }

        {
            Ticket ticket = new Ticket();
            int[] a = new int[]{
                    11, 11, 11, 12, 16, 16, 17, 18
            };
            int[] b = new int[]{
                    13, 20
            };
            // 15
            System.out.println(ticket.lastTicket(a, b, 3));
        }

        {
            Ticket ticket = new Ticket();
            int[] a = new int[]{
                    11, 12, 15, 15, 15
            };
            int[] b = new int[]{
                    11, 20
            };
            // 14
            System.out.println(ticket.lastTicket(a, b, 2));
        }
    }

}
