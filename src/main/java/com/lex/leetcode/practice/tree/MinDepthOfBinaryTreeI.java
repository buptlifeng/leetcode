package com.lex.leetcode.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 简单
 *
 * @author lifeng
 */
public class MinDepthOfBinaryTreeI {

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

    private int curMinDepth = Integer.MAX_VALUE;
    public int minDepthOptimize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMinDepth(root, 1);
        return curMinDepth;
    }

    private void getMinDepth(TreeNode node, int level){
        if(node == null){
            return;
        }
        // 如果是叶子节点，结束递归
        if (node.left == null && node.right == null) {
            curMinDepth = Math.min(curMinDepth, level);
        }
        // 不可能最小，提前返回
        if(level >= curMinDepth){
            return;
        }
        level++;
        getMinDepth(node.left, level);
        getMinDepth(node.right, level);
    }

    /**
     * 递归写法
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 如果是叶子节点，结束递归
        if (root.left == null && root.right == null) {
            return 1;
        }

        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth, minDepth(root.left));
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth, minDepth(root.right));
        }
        return minDepth + 1;
    }

    public static void main(String[] args) {
        MinDepthOfBinaryTreeI solution = new MinDepthOfBinaryTreeI();
        TreeNode root = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode r2 = new TreeNode(4);
        TreeNode r3 = new TreeNode(5);
        TreeNode r4 = new TreeNode(6);

        root.right = r1;
        r1.right = r2;
        r2.right = r3;
        r3.right = r4;
        System.out.println(solution.minDepth(root));
    }

}
