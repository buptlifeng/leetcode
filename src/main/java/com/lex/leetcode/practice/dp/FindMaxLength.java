package com.lex.leetcode.practice.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/contiguous-array/
 * 中等
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/6/23 下午9:57
 */
public class FindMaxLength {

    /**
     * 1.前缀和
     * 2.哈希表
     * 求最大长度
     *
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        // counter记录1的数量
        int counter = 0, ans = 0;
        // key: 1的数量 value: 下标
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                counter++;
            } else {
                counter--;
            }
            // 表示从前一个位置到i，中间段的1，0数量是相等的
            if (map.containsKey(counter)) {
                int preIndex = map.get(counter);
                ans = Math.max(ans, i - preIndex);
            } else {
                // 更新最新的下标
                map.put(counter, i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        {
            FindMaxLength fml = new FindMaxLength();
            int[] nums = new int[]{
                    1, 0
            };
            // 2 [1,0]
            System.out.println(fml.findMaxLength(nums));
        }

        {
            FindMaxLength fml = new FindMaxLength();
            int[] nums = new int[]{
                    1, 0, 1
            };
            // 2 [1,0] [0,1]
            System.out.println(fml.findMaxLength(nums));
        }
    }

}
