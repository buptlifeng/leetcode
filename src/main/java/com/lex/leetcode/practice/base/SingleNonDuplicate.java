package com.lex.leetcode.practice.base;

/**
 * https://leetcode-cn.com/problems/single-element-in-a-sorted-array
 * 中等
 * <p>
 * TODO
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/5/5 下午3:48
 */
public class SingleNonDuplicate {

    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            boolean numOfPartEven = (high - mid) % 2 == 0;
            // 包含只出现一次元素的区间，总长度肯定是奇数
            if (nums[mid] == nums[mid + 1]) {
                // 相同元素在右侧，右侧包含偶数个元素，删除相同元素后，还剩奇数个，所以左指针右移2个
                if (numOfPartEven) {
                    low = mid + 2;
                } else {
                    // 参考上面说法，右指针左移一个
                    high = mid - 1;
                }
            } else if (nums[mid] == nums[mid - 1]) {
                if (numOfPartEven) {
                    high = mid - 2;
                } else {
                    low = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {

        {
            SingleNonDuplicate snd = new SingleNonDuplicate();
            int[] nums = new int[]{
                    1, 1, 2, 3, 3, 4, 4, 8, 8
            };
            // 2
            System.out.println(snd.singleNonDuplicate(nums));
        }

        {
            SingleNonDuplicate snd = new SingleNonDuplicate();
            int[] nums = new int[]{
                    3, 3, 7, 7, 10, 11, 11
            };
            // 10
            System.out.println(snd.singleNonDuplicate(nums));
        }

    }

}
