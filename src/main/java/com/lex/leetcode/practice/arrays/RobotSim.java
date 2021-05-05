package com.lex.leetcode.practice.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/walking-robot-simulation/
 * 简单
 *
 * @author lifeng
 */
public class RobotSim {

    /**
     * 重点在于中间可能有障碍点，不能直接跨过
     * 由于障碍点都限制了范围，可以将障碍点编码成一个long数字，放在Set里，每次直接通过Set匹配，而不是每次遍历数组
     *
     * @param commands
     * @param obstacles
     * @return
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        int max = 0;
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};

        Set<Long> encodedObstacleSet = new HashSet<Long>();
        for (int[] pos : obstacles) {
            // 因为x,y [-30000,30000]
            encodedObstacleSet.add(((pos[0] + 30000) << 16) + (long) (pos[1] + 30000));
        }

        int direct = 0, x = 0, y = 0;
        for (int cmd : commands) {
            if (cmd == -2) {
                // turn left
                direct = (direct + 3) % 4;
            } else if (cmd == -1) {
                // turn right
                direct = (direct + 1) % 4;
            } else {
                for (int i = 1; i <= cmd; i++) {
                    int px = x + dx[direct];
                    int py = y + dy[direct];
                    long obstacle = (((long) px + 30000) << 16) + ((long) py + 30000);
                    if (!encodedObstacleSet.contains(obstacle)) {
                        x = px;
                        y = py;
                        max = Math.max(max, x * x + y * y);
                    }
                }
            }
        }

        return max;
    }

}
