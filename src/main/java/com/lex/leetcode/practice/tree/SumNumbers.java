package com.lex.leetcode.practice.tree;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * 中等
 *
 * @author lifeng
 */
public class SumNumbers {

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

    public int sumNumbers(TreeNode root) {
        return dfs(root, new LinkedList<>());
    }

    private int dfs(TreeNode node, LinkedList<TreeNode> list) {
        int sum = 0;
        if (node == null) {
            return 0;
        }
        list.addLast(node);
        if (node.left == null && node.right == null) {
            sum += readNum(list);
        } else {
            int ls = dfs(node.left, list);
            int rs = dfs(node.right, list);
            sum += (ls + rs);
        }
        list.removeLast();
        return sum;
    }

    public int readNum(LinkedList<TreeNode> list) {
        int sum = 0;
        for (TreeNode node : list) {
            sum *= 10;
            sum += node.val;
        }
        return sum;
    }

    public static void main(String[] args) {
        {
            SumNumbers solution = new SumNumbers();

            TreeNode root = new TreeNode(1);
            TreeNode rl = new TreeNode(2);
            TreeNode rr = new TreeNode(3);

            root.left = rl;
            root.right = rr;
            System.out.println(solution.sumNumbers(root));
        }

        {
            SumNumbers solution = new SumNumbers();

            TreeNode root = new TreeNode(4);
            TreeNode rl = new TreeNode(9);
            TreeNode rr = new TreeNode(0);

            root.left = rl;
            root.right = rr;

            TreeNode ll = new TreeNode(5);
            TreeNode lr = new TreeNode(1);
            rl.left = ll;
            rl.right = lr;
            System.out.println(solution.sumNumbers(root));
        }
    }

}
