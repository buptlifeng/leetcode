package com.lex.leetcode.practice.tree;

/**
 * https://leetcode-cn.com/problems/deepest-leaves-sum/
 * 中等
 * <p>
 * 层次最深的叶子节点之和
 *
 * @version 1.0
 * @description
 * @auth lex
 * @date 2021/7/19 下午10:08
 */
public class DeepestLeavesSum {
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

    private int maxDepth = -1;
    private int total = 0;

    public int deepestLeavesSum(TreeNode root) {
        deepestLeavesSum(root, 0);
        return total;
    }

    private void deepestLeavesSum(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth > this.maxDepth) {
            this.maxDepth = depth;
            this.total = root.val;
        } else if (depth == this.maxDepth) {
            this.total += root.val;
        }
        deepestLeavesSum(root.left, depth + 1);
        deepestLeavesSum(root.right, depth + 1);
    }

    public static void main(String[] args) {
        DeepestLeavesSum dls = new DeepestLeavesSum();
        dls.deepestLeavesSum(null);
    }

}
