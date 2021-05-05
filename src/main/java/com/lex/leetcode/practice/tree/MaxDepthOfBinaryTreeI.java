package com.lex.leetcode.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 简单
 *
 * @author lifeng
 */
public class MaxDepthOfBinaryTreeI {

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

    /**
     * 递归写法
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode node, int curDepth) {
        if (node == null) {
            return curDepth;
        }
        return Math.max(maxDepth(node.left, curDepth + 1), maxDepth(node.right, curDepth + 1));
    }

    /**
     * 层次遍历写法
     * 每次将一层的节点保存起来，然后不停的更新为下一层次的节点
     * 直到下一层次节点个数为0，遍历的次数为最大深度
     *
     * @param root
     * @return
     */
    public int maxDepthLevel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(root);
        while (queue.size() > 0) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            depth++;
        }

        return depth;
    }

}
