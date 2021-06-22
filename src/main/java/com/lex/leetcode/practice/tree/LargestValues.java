package com.lex.leetcode.practice.tree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 * 中等
 *
 * @author lifeng
 */
public class LargestValues {

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
     * 普通的层次遍历即可
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {

        return null;
    }

    public static void main(String[] args) {
        LargestValues solution = new LargestValues();
        TreeNode root = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode r2 = new TreeNode(4);
        TreeNode r3 = new TreeNode(5);
        TreeNode r4 = new TreeNode(6);

        root.right = r1;
        r1.right = r2;
        r2.right = r3;
        r3.right = r4;
        System.out.println(solution.largestValues(root));
    }

}
