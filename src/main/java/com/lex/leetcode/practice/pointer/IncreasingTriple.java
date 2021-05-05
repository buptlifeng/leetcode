package com.lex.leetcode.practice.pointer;

/**
 * https://leetcode-cn.com/problems/increasing-triplet-subsequence/
 * 中等
 *
 * @author lifeng
 */
public class IncreasingTriple {

    /**
     * 数组nums是无序的
     * 找到满足i<j<k，使得：nums[i]<nums[j]<nums[k]
     * 如果存在，返回true
     * 否则，返回false
     * <p>
     * 常规解法：O(n^3)
     *
     * @param nums
     * @return
     */
    public boolean increasingTripletOn3(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (nums[j] > nums[i]) {
                    for (int k = n - 1; k > j; k--) {
                        if (nums[k] > nums[j]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * 要求：
     * 时间：O(n)
     * 空间：O(1)
     *
     * @param nums
     * @return
     */
    public boolean increasingTripletOnO1(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int no : nums) {
            if (no < first) {
                first = no;
            } else if (no < second) {
                second = no;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean increasingTripletOnOn(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int[] forward = new int[n];
        int[] back = new int[n];

        forward[0] = nums[0];
        back[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            forward[i] = Math.min(forward[i - 1], nums[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            back[i] = Math.max(back[i + 1], nums[i]);
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > forward[i] && nums[i] < back[i]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        {
            IncreasingTriple solution = new IncreasingTriple();
            int[] nums = new int[]{
                    1, 2, 3, 4, 5
            };
            // true
            System.out.println(solution.increasingTripletOn3(nums));
            System.out.println(solution.increasingTripletOnO1(nums));
        }

        {
            IncreasingTriple solution = new IncreasingTriple();
            int[] nums = new int[]{
                    5, 4, 3, 2, 1
            };
            // false
            System.out.println(solution.increasingTripletOn3(nums));
            System.out.println(solution.increasingTripletOnO1(nums));
        }

        {
            IncreasingTriple solution = new IncreasingTriple();
            int[] nums = new int[]{
                    2, 1, 5, 0, 4, 6
            };
            // true
            System.out.println(solution.increasingTripletOn3(nums));
            System.out.println(solution.increasingTripletOnO1(nums));
        }
    }

}
