package com.lex.leetcode.practice.arrays;

/**
 * https://leetcode-cn.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/
 * 中等
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/8/1 下午8:11
 */
public class FindLengthOfShortestSubarray {

    /**
     * 因为只能删除一段，所以：
     * 1.移除左侧开头的；
     * 2.移除右侧结尾的；
     * 3.移除中间的一段；
     * 因此：
     * 1.先找到从左开始的最长非递减序列；
     * 2.找到从又开始的最长非递增序列；
     * 3.根据左右的值，更新可移除的数组长度，最终取最小值；
     *
     * @param arr
     * @return
     */
    public int findLengthOfShortestSubarrayDoublePoint(int[] arr) {
        int left = 0, n = arr.length;
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }
        if (left == n - 1) {
            return 0;
        }
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        // 删除左侧[0,right-1]或者右侧[left+1, n-1]
        int ans = Math.min(n - left - 1, right);
        int i = 0, j = right;
        // 左右各保留一部分
        while (i <= left && j <= n - 1) {
            if (arr[i] <= arr[j]) {
                // [0,i],[j,n-1]有序,删除[i+1,j-1]
                ans = Math.min(ans, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return ans;
    }

    /**
     * 该方法超出内存限制
     *
     * @param arr
     * @return
     */
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        boolean[][] exists = new boolean[n][n];
        // 1.处理局部问题
        for (int i = 0; i < n; i++) {
            int pre = arr[i];
            for (int j = i; j < n; j++) {
                if (arr[j] >= pre) {
                    // 标记[i,j]是有序的
                    pre = arr[j];
                    exists[i][j] = true;
                } else {
                    // 标记从i开始的元素，到j结尾的元素，整体无序
                    break;
                }
            }
        }
        // 2.通过预处理的元素，找到最大值
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 2.1 左侧从头开始是有效地
            // 2.2 左侧需要移除，这种情况下，右侧的需要全部非降序排列才行
            if (i == 0) {
                for (int j = i; j < n; j++) {
                    if (exists[0][j]) {
                        // 如果0,j是有序的，从后序找到一个开始值不大于arr[j]的有序序列
                        int maxLen = findLongestSubArray(exists, arr, arr[j], j + 1);
                        ans = Math.max(ans, maxLen + j - i + 1);
                    } else {
                        if (exists[j][n - 1]) {
                            ans = Math.max(ans, n - j);
                        }
                    }
                }
            } else {
                if (exists[i][n - 1]) {
                    ans = Math.max(ans, n - i);
                }
            }
        }

        return n - ans;
    }

    private int findLongestSubArray(boolean[][] exists, int[] arr, int preEndNum, int start) {
        int n = arr.length;
        int len = 0, left = n - 1;
        while (left >= start) {
            if (exists[left][n - 1]) {
                if (arr[left] >= preEndNum) {
                    len = Math.max(len, n - left);
                }
                left--;
            } else {
                break;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        {
            // 只能移除一段连续的子数组，实际实现忽略了左侧开头的数组需要移除的情况
            FindLengthOfShortestSubarray flss = new FindLengthOfShortestSubarray();
            int[] arr = new int[]{
                    13, 0, 14, 7, 18, 18, 18, 16, 8, 15, 20
            };
            // 8 => 0,14,7,18,18,18,16,8 保留 13 15 20
            System.out.println(flss.findLengthOfShortestSubarray(arr));
            System.out.println(flss.findLengthOfShortestSubarrayDoublePoint(arr));
        }

        {
            FindLengthOfShortestSubarray flss = new FindLengthOfShortestSubarray();
            int[] arr = new int[]{
                    1, 2, 3, 10, 0, 7, 8, 9
            };
            // 2 => 10,0
            System.out.println(flss.findLengthOfShortestSubarray(arr));
            System.out.println(flss.findLengthOfShortestSubarrayDoublePoint(arr));
        }

        {
            FindLengthOfShortestSubarray flss = new FindLengthOfShortestSubarray();
            int[] arr = new int[]{
                    1, 3, 2, 4
            };
            // 1 => 3 移除元素3即可
            System.out.println(flss.findLengthOfShortestSubarray(arr));
            System.out.println(flss.findLengthOfShortestSubarrayDoublePoint(arr));
        }

        {
            FindLengthOfShortestSubarray flss = new FindLengthOfShortestSubarray();
            int[] arr = new int[]{
                    1, 2, 3, 10, 4, 2, 3, 5
            };
            // 3 => 10,4,2
            System.out.println(flss.findLengthOfShortestSubarray(arr));
            System.out.println(flss.findLengthOfShortestSubarrayDoublePoint(arr));
        }

        {
            FindLengthOfShortestSubarray flss = new FindLengthOfShortestSubarray();
            int[] arr = new int[]{
                    5, 4, 3, 2, 1
            };
            // 4 => 5,4,3,2 或 4,3,2,1
            System.out.println(flss.findLengthOfShortestSubarray(arr));
            System.out.println(flss.findLengthOfShortestSubarrayDoublePoint(arr));
        }

        {
            FindLengthOfShortestSubarray flss = new FindLengthOfShortestSubarray();
            int[] arr = new int[]{
                    1, 2, 3
            };
            // 0 => 不需要删除元素
            System.out.println(flss.findLengthOfShortestSubarray(arr));
            System.out.println(flss.findLengthOfShortestSubarrayDoublePoint(arr));
        }

        {
            FindLengthOfShortestSubarray flss = new FindLengthOfShortestSubarray();
            int[] arr = new int[]{
                    1
            };
            // 0
            System.out.println(flss.findLengthOfShortestSubarray(arr));
            System.out.println(flss.findLengthOfShortestSubarrayDoublePoint(arr));
        }
    }

}
