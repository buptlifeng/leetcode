package com.lex.leetcode.practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 * 中等
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < n; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int third = n - 1, target = -nums[first];
            for (int sec = first + 1; sec < n; sec++) {
                if (sec > first + 1 && nums[sec] == nums[sec - 1]) {
                    continue;
                }

                while (sec < third && nums[sec] + nums[third] > target) {
                    third--;
                }

                if (sec == third) {
                    break;
                }

                if (nums[sec] + nums[third] == target) {
                    List<Integer> eles = new ArrayList<>();
                    eles.add(nums[first]);
                    eles.add(nums[sec]);
                    eles.add(nums[third]);
                    result.add(eles);
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        System.out.println(solution.threeSum(new int[]{
                -1, 0, 1, 2, -1, -4
        }));

        System.out.println(solution.threeSum(new int[]{}));

        System.out.println(solution.threeSum(new int[]{
                0
        }));
    }

}
