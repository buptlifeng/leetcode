package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/majority-element/
 * 简单
 *
 * @author lifeng
 */
public class MajorElement {

    /**
     * 找出一个超过半数的元素很容易，
     * 挑战：O(n)时间和O(1)空间
     *
     * @param nums
     * @return
     */
    public int majorityElementRecursion(int[] nums) {

        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private int majorityElementRec(int[] nums, int lf, int rh) {
        if (lf == rh) {
            return nums[lf];
        }

        int mid = (rh + lf) / 2;
        int ll = majorityElementRec(nums, lf, mid);
        int rr = majorityElementRec(nums, mid + 1, rh);
        if (ll == rr) {
            return ll;
        }

        int lfWinner = countMajor(nums, ll, lf, mid);
        int rhWinner = countMajor(nums, rr, mid + 1, rh);
        return lfWinner > rhWinner ? ll : rr;
    }

    private int countMajor(int[] nums, int val, int st, int end) {
        int count = 0;
        for (int i = st; i <= end; i++) {
            if (val == nums[i]) {
                count++;
            }
        }
        return count;
    }

}
