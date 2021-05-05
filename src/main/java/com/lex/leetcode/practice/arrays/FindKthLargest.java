package com.lex.leetcode.practice.arrays;

import java.util.Random;

/**
 * FIXME 重点复习
 * 大根堆  快排划分
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * 中等
 *
 * @author lifeng
 */
public class FindKthLargest {

    public int findKthLargestWithHeap(int[] nums, int k) {
        // 首先构造大根堆
        int hsize = nums.length, len = nums.length;
        buildHeap(nums, hsize);
        for (int i = len - 1; i >= len - k + 1; i--) {
            // 将堆顶元素复制到数组最后，对剩下的元素再次构建堆
            // 这样重复，数组最后分别对应着前k个最大数
            swap(nums, 0, i);
            hsize--;
            maxHeapify(nums, 0, hsize);
        }
        return nums[0];
    }

    /**
     * 自底向上
     */
    private void buildHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    private void maxHeapify(int[] nums, int i, int heapSize) {
        int lc = 2 * i + 1, rc = 2 * i + 2, largest = i;
        if (lc < heapSize && nums[lc] > nums[i]) {
            largest = lc;
        }
        if (rc < heapSize && nums[rc] > nums[i]) {
            largest = rc;
        }
        if (largest != i) {
            // 将最大值设置为父节点
            swap(nums, i, largest);
            // 递归堆子节点进行调整
            maxHeapify(nums, largest, heapSize);
        }
    }

    /**
     * 快速选择
     * 1.可以快排之后选择第k个
     * 2.参考快排的划分，如果下标是k，直接返回即可
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int l, int r, int tIndex) {
        int q = rndPartition(nums, l, r);
        if (q == tIndex) {
            return nums[q];
        } else {
            return q < tIndex ? quickSelect(nums, q + 1, r, tIndex) : quickSelect(nums, l, q - 1, tIndex);
        }
    }

    Random random = new Random();

    private int rndPartition(int[] nums, int l, int r) {
        int rnd = random.nextInt(r - l + 1) + 1;
        swap(nums, rnd, r);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int p = nums[r], idx = l - 1;
        for (int j = l; j < r; j++) {
            // 将小于p（轴）的数全部复制到左侧(相对于idx)
            if (nums[j] <= p) {
                swap(nums, ++idx, j);
            }
        }
        // 保证轴p在中间 因为++idx后，idx保存着小于p的值，所以次数需要+1
        swap(nums, idx + 1, r);
        return idx + 1;
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public static void main(String[] args) {
        {
            FindKthLargest solution = new FindKthLargest();
            int[] nums = new int[]{
                    3, 2, 1, 5, 6, 4
            };
            // 5
            System.out.println(solution.findKthLargest(nums, 2));
            System.out.println(solution.findKthLargestWithHeap(nums, 2));
        }

        {
            FindKthLargest solution = new FindKthLargest();
            int[] nums = new int[]{
                    3, 2, 3, 1, 2, 4, 5, 5, 6
            };
            // 4
            System.out.println(solution.findKthLargest(nums, 4));
            System.out.println(solution.findKthLargestWithHeap(nums, 4));
        }
    }


}
