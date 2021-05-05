package com.lex.leetcode.practice.tree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 * 简单
 * 二叉搜索树指定范围内的和
 *
 * @author lifeng
 */
public class RangeSumBST {

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
     * 迭代写法
     *
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBSTIteration(TreeNode root, int low, int high) {
        int ret = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node != null){
                if (node.val >= low && node.val <= high) {
                    ret += node.val;
                }
                if (node.val > low) {
                    stack.push(node.left);
                }
                if (node.val < high) {
                    stack.push(node.right);
                }
            }
        }
        return ret;
    }

    int sum = 0;

    /**
     * 递归写法
     *
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBSTRecursion(TreeNode root, int low, int high) {
        sum = 0;
        dfs(root, low, high);
        return sum;
    }

    void dfs(TreeNode node, int low, int high) {
        if (node != null) {
            int val = node.val;
            if (val >= low && val <= high) {
                sum += val;
            }
            // 可能左右子树都需要遍历，通过2个if来实现按需遍历
            // 先判断是否需要遍历左子树
            if (val > low) {
                dfs(node.left, low, high);
            }
            // 再判断是否需要遍历右子树
            if (val < high) {
                dfs(node.right, low, high);
            }
        }
    }

    public static void main(String[] args) {
        RangeSumBST solution = new RangeSumBST();
        TreeNode root = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode r2 = new TreeNode(4);
        TreeNode r3 = new TreeNode(5);
        TreeNode r4 = new TreeNode(6);

        root.right = r1;
        r1.right = r2;
        r2.right = r3;
        r3.right = r4;
        System.out.println(solution.rangeSumBSTRecursion(root, 3, 5));

        System.out.println(solution.rangeSumBSTIteration(root, 3, 5));
    }

}
