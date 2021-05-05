package com.lex.leetcode.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree/
 * 中等
 *
 * @author lifeng
 */
public class IsCompleteTree {

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

    class MarkNode {
        TreeNode node;
        int no;

        MarkNode(TreeNode node, int no) {
            this.node = node;
            this.no = no;
        }
    }

    public boolean isCompleteTreeIteration1(TreeNode root) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.addFirst(root);
        // 记录是否已经访问过NULL元素
        boolean accessNull = false;
        while (!nodes.isEmpty()) {
            TreeNode cur = nodes.removeFirst();
            if (accessNull && cur != null) {
                return false;
            }
            if (cur == null) {
                accessNull = true;
                continue;
            }

            nodes.offerLast(cur.left);
            nodes.offerLast(cur.right);
        }
        return true;
    }


    /**
     * 除叶子层外，都是满的
     * 叶子层，所有叶子节点相邻没有空隙，否则就不是完全树
     *
     * @param root
     * @return
     */
    public boolean isCompleteTreeIteration2(TreeNode root) {
        List<MarkNode> levelNodes = new ArrayList<>();
        levelNodes.add(new MarkNode(root, 1));
        int index = 0;
        while (index < levelNodes.size()) {
            MarkNode node = levelNodes.get(index++);
            if (node != null) {
                levelNodes.add(new MarkNode(node.node.left, node.node.val * 2));
                levelNodes.add(new MarkNode(node.node.right, node.node.val * 2 + 1));
            }
        }
        // 如果中间缺元素，最后的编号和列表元素个数肯定不一致
        return levelNodes.get(index - 1).no == levelNodes.size();
    }

    public static void main(String[] args) {

    }

}
