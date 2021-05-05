package com.lex.leetcode.practice.tree;

/**
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 * 简单
 *
 * @author lifeng
 */
public class MinDistanceBetweenBstNodes {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private Integer prev, min;

    /**
     * 二叉搜索树，求最小值，肯定是相邻2个节点之间的=》错误，可能存在根节点和最大左子（孙）节点或最小右子（孙）节点
     * 1.正确的应该是使用中序遍历，然后顺序计算相邻2个元素的差值，取最小
     * 2.也可以写入到一个数组，排序之后顺序取最小差值即可
     *
     * 本实现采用中序遍历法
     *
     * @param root
     * @return
     */
    public int minDiffInBST(TreeNode root) {
        prev = null;
        min = Integer.MAX_VALUE;
        middleScan(root);
        return min;
    }

    private void middleScan(TreeNode node) {
        if (node == null) {
            return;
        }
        middleScan(node.left);
        // 每次取当前节点，和中序前一节点计算差值
        if (prev != null) {
            min = Math.min(min, node.val - prev);
        }
        prev = node.val;
        middleScan(node.right);
    }

    public static void main(String[] args) {
        MinDistanceBetweenBstNodes solution = new MinDistanceBetweenBstNodes();
        TreeNode root = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode r2 = new TreeNode(4);
        TreeNode r3 = new TreeNode(5);
        TreeNode r4 = new TreeNode(6);

        root.right = r1;
        r1.right = r2;
        r2.right = r3;
        r3.right = r4;
        System.out.println(solution.minDiffInBST(root));

    }

}
