package com.lex.leetcode.practice.dp;

/**
 * https://leetcode-cn.com/problems/jump-game-ii/
 * <p>
 * 困难
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * <p>
 * TODO
 *
 * @author lifeng
 */
public class Jump2 {

    /**
     * 贪心算法，每次选能跳最远的值
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int len = nums.length, steps = 0;
        if(len == 1){
            return 0;
        }
        int point = 0;
        while (point < len) {
            steps++;
            // 遍历轮次
            int round = nums[point];
            // 该点的值已经超过当前剩下的长度
            if (round + point >= len - 1) {
                point += round;
                break;
            }
            int maxPosIndex = point + round;
            for (int i = 1; i <= round; i++) {
                // 同样的跳转值，靠后的优先级更高因此有等号
                if (point + i < len && nums[point + i] + point + i >= maxPosIndex) {
                    // 更新记录最大值下标，可能超过数据上限
                    maxPosIndex = point + i + nums[point + i];

                }
            }
            point = maxPosIndex;
        }
        return steps;
    }

    public static void main(String[] args) {
        Jump2 solution = new Jump2();

        int[] nums = new int[]{
                1, 2, 1, 1, 1
        };
        // 3
        System.out.println(solution.jump(nums));

        nums = new int[]{
                1,2,0,1
        };
        // 2
        System.out.println(solution.jump(nums));

        nums = new int[]{
                1,3,2
        };
        // 2
        System.out.println(solution.jump(nums));

        nums = new int[]{
                1,2,3
        };
        // 2
        System.out.println(solution.jump(nums));

        nums = new int[]{
                10,9,8,7,6,5,4,3,2,1,1,0
        };
        // 2
        System.out.println(solution.jump(nums));

        nums = new int[]{
                2, 3, 1
        };
        // 1
        System.out.println(solution.jump(nums));

        nums = new int[]{
                3, 2, 1
        };
        // 1
        System.out.println(solution.jump(nums));

        nums = new int[]{
                2, 1
        };
        // 1
        System.out.println(solution.jump(nums));

        nums = new int[]{
                2, 3, 1, 1, 4
        };
        // 2
        System.out.println(solution.jump(nums));
    }

}
