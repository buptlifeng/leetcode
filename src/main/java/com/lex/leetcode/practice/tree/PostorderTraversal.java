package com.lex.leetcode.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * 中等
 *
 * @author lifeng
 */
public class PostorderTraversal {

    static class TreeNode {
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
     * 使用栈，依次将根节点压入栈，然后将左子节点压入，直到左子节点为null，
     * 每弹出一个节点，然后压入该节点的右子节点
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalIteration(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 什么时候打印节点值？右节点为空，或者前驱节点已经访问过
            if (root.right == null || root.right == prev) {
                list.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }

    /**
     * 递归算法
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        dfs(node.left, list);
        dfs(node.right, list);
        list.add(node.val);
    }

    public static void main(String[] args) {
        {
            PostorderTraversal pot = new PostorderTraversal();

            TreeNode root = new TreeNode(1);
            TreeNode rl = new TreeNode(2);
            TreeNode rr = new TreeNode(3);
            root.left = rl;
            root.right = rr;

            TreeNode rll = new TreeNode(4);
            TreeNode rlr = new TreeNode(5);
            rl.left = rll;
            rl.right = rlr;

            TreeNode rrr = new TreeNode(7);
            rr.right = rrr;

            List<Integer> list1 = pot.postorderTraversalRecursion(root);
            System.out.println(list1);

            List<Integer> list2 = pot.postorderTraversalIteration(root);
            System.out.println(list2);
        }
    }

}
