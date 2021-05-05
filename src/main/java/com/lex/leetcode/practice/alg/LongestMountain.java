package com.lex.leetcode.practice.alg;

/**
 * https://leetcode-cn.com/problems/longest-mountain-in-array/
 * 中等
 *
 * @author lifeng
 */
public class LongestMountain {

    /**
     * 分别记下左侧开始最长的升序子数组长度，右侧开始最长的降序子数组长度
     *
     * @param arr
     * @return
     */
    public int longestMountainDp(int[] arr) {
        int ans = 0, n = arr.length;
        int[] ldp = new int[n];
        // 从前往后
        for (int i = 1; i < n; i++) {
            ldp[i] = arr[i] > arr[i - 1] ? (ldp[i - 1] + 1) : 0;
        }

        int[] rdp = new int[n];
        // 从后往前
        for (int i = n - 2; i >= 0; i--) {
            rdp[i] = arr[i] > arr[i + 1] ? (rdp[i + 1] + 1) : 0;
        }

        // 枚举所有ldp[i]>0 && rdp[i]>0的点，并选最大值
        for (int i = 0; i < n; i++) {
            if (ldp[i] > 0 && rdp[i] > 0) {
                ans = Math.max(ans, ldp[i] + rdp[i] + 1);
            }
        }

        return ans;
    }

    /**
     * 双指针
     *
     * @param arr
     * @return
     */
    public int longestMountainDoublePoint(int[] arr) {
        int n = arr.length, l = 0, ans = 0;
        while (l + 2 < n) {
            int cur = l + 1;
            if (arr[cur] > arr[l]) {
                while (cur + 1 < n && arr[cur + 1] > arr[cur]) {
                    cur++;
                }
                if (cur < n - 1 && arr[cur] > arr[cur + 1]) {
                    while (cur + 1 < n && arr[cur] > arr[cur + 1]) {
                        cur++;
                    }
                    ans = Math.max(ans, cur - l + 1);
                } else {
                    // 非单调的，设置为下一轮遍历起点
                    cur++;
                }
            }
            l = cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        {
            LongestMountain lm = new LongestMountain();
            int[] arr = new int[]{
                    2, 1, 4, 7, 3, 2, 5
            };
            // 5
            System.out.println(lm.longestMountainDoublePoint(arr));
            System.out.println(lm.longestMountainDp(arr));
        }

        {
            LongestMountain lm = new LongestMountain();
            int[] arr = new int[]{
                    2, 2, 2
            };
            // 0
            System.out.println(lm.longestMountainDoublePoint(arr));
            System.out.println(lm.longestMountainDp(arr));
        }
    }

}
