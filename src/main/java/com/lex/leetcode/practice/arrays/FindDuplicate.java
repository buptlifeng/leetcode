package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 * 中等
 *
 * @author lifeng
 */
public class FindDuplicate {

    /**
     * 元素可以重复任意次数
     * 快慢指针：
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = 0,fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int pre = 0;
        while (pre != slow){
            slow = nums[slow];
            pre = nums[pre];
        }
        return pre;
    }

    public static void main(String[] args) {
        {
            FindDuplicate solution = new FindDuplicate();
            int[] nums = new int[]{
                    1, 3, 4, 2, 2
            };
            System.out.println(solution.findDuplicate(nums));
        }

        {
            FindDuplicate solution = new FindDuplicate();
            int[] nums = new int[]{
                    3, 1, 3, 4, 2
            };
            System.out.println(solution.findDuplicate(nums));
        }

        {
            FindDuplicate solution = new FindDuplicate();
            int[] nums = new int[]{
                    1, 1
            };
            System.out.println(solution.findDuplicate(nums));
        }

        {
            FindDuplicate solution = new FindDuplicate();
            int[] nums = new int[]{
                    1, 1, 2
            };
            System.out.println(solution.findDuplicate(nums));
        }
    }

}
