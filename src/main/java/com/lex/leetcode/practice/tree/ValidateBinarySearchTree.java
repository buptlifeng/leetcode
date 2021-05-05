package com.lex.leetcode.practice.tree;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * <p>
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 */
public class ValidateBinarySearchTree {

    class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBSTRecursion(TreeNode root) {

        return validateHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * 中序遍历，得到的序列一定是有序的，否则，就不是
     *
     * @param root
     * @return
     */
    public boolean isValidBSTMiddle(TreeNode root) {

        Stack<TreeNode> stack = new Stack<TreeNode>();
        int preVal = Integer.MIN_VALUE;
        while (!stack.empty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= preVal) {
                return false;
            }
            preVal = root.val;
            root = root.right;
        }
        return false;
    }

    private boolean validateHelper(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (upper <= node.val || lower >= node.val) {
            return false;
        }

        // 递归
        return validateHelper(node.left, lower, node.val) && validateHelper(node.right, node.val, upper);
    }


}
