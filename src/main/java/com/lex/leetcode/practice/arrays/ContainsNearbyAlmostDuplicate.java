package com.lex.leetcode.practice.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-iii/
 * 中等
 */
public class ContainsNearbyAlmostDuplicate {

    // In Java, `-3 / 5 = 0` and but we need `-3 / 5 = -1`.
    private long getBuckNo(long x, long w) {
        return x < 0 ? ((x + 1) / w - 1) : x / w;
    }

    /**
     * 在整数数组 nums 中，是否存在两个下标 i 和 j，使得
     * 1. nums [i] 和 nums [j] 的差的绝对值小于等于 t ，
     * 2. 且满足 i 和 j 的差的绝对值也小于等于 ķ
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Long, Long> buckets = new HashMap<>();
        long step = (long) t + 1;
        for (int i = 0; i < nums.length; i++) {
            // 先假设所有的元素都满足j-i<k
            long buckNo = getBuckNo(nums[i], step);

            // 1.和当前桶比较
            if (buckets.containsKey(buckNo)) {
                return true;
            }

            // 2.分别和可能存在的左侧桶进行比较
            if (buckets.containsKey(buckNo - 1) && Math.abs(nums[i] - buckets.get(buckNo - 1)) < step) {
                return true;
            }

            // 3.和可能存在的右侧桶进行比较
            if (buckets.containsKey(buckNo + 1) && Math.abs(nums[i] - buckets.get(buckNo + 1)) < step) {
                return true;
            }

            // 4.先放入当前元素，然后移除i,j不符合要求的元素
            buckets.put(buckNo, (long) nums[i]);
            if (i >= k) {
                buckets.remove(getBuckNo(nums[i - k], step));
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyAlmostDuplicate solution = new ContainsNearbyAlmostDuplicate();

        {
            int[] nums = new int[]{1, 2, 3, 1};
            int k = 3;
            int t = 0;
            System.out.println(solution.containsNearbyAlmostDuplicate(nums, k, t));
        }

        {
            int[] nums = new int[]{1, 0, 1, 1};
            int k = 1;
            int t = 2;
            System.out.println(solution.containsNearbyAlmostDuplicate(nums, k, t));
        }

        {
            int[] nums = new int[]{1, 5, 9, 1, 5, 9};
            int k = 2;
            int t = 3;
            System.out.println(solution.containsNearbyAlmostDuplicate(nums, k, t));
        }
    }

}
