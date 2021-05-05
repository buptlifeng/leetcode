package com.lex.leetcode.practice.pointer;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 中等
 *
 * @author lifeng
 */
public class MaxArea {

    /**
     * 双指针，逐渐靠拢
     * 优先移动当前高度值更低的指针
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, ans = 0;
        while (l < r) {
            int area = (Math.min(height[l], height[r])) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxArea ma = new MaxArea();
        int[] heights = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(ma.maxArea(heights));

        heights = new int[]{1, 1};
        System.out.println(ma.maxArea(heights));

        heights = new int[]{4, 3, 2, 1, 4};
        System.out.println(ma.maxArea(heights));

        heights = new int[]{1, 2, 1};
        System.out.println(ma.maxArea(heights));
    }

}
