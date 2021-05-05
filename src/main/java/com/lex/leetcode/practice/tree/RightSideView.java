package com.lex.leetcode.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 * 中等
 *
 * @author lifeng
 */
public class RightSideView {

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
     * 从右侧看上去的节点，按层次打印
     * @param root
     * @return
     */
    public List<Integer> rightSideViewIteration(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        if(root != null) {
            list.addFirst(root);
        }
        while (!list.isEmpty()){
            int size = list.size();
            TreeNode rightNode = list.getLast();
            if(rightNode != null){
                ans.add(rightNode.val);
            }
            while (size > 0) {
                TreeNode node = list.removeFirst();
                if(node.left != null){
                    list.offerLast(node.left);
                }

                if(node.right != null){
                    list.offerLast(node.right);
                }
                size--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        {
            RightSideView solution = new RightSideView();
            TreeNode root = new TreeNode(4);
            TreeNode r1 = new TreeNode(2);
            TreeNode r2 = new TreeNode(1);
            TreeNode r3 = new TreeNode(3);
            TreeNode r4 = new TreeNode(7);

            root.left = r1;
            root.right = r4;

            r1.left = r2;
            r1.right = r3;

            List<Integer> ans = solution.rightSideViewIteration(root);
            System.out.println(ans);
        }
    }

}
