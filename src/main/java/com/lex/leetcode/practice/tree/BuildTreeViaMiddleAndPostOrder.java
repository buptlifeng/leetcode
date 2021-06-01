package com.lex.leetcode.practice.tree;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 中等
 *
 * @author lifeng
 */
public class BuildTreeViaMiddleAndPostOrder {

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
     * 1.先根据后序找到根节点
     * 2.根据中序，找到左子树和右子树分别进行递归处理
     * 3.没有重复元素=很重要
     * <p>
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     * 返回如下的树：
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int il, int ir, int[] postorder, int pl, int pr) {
        // 1.后序找到根节点
        if (il > ir || pr < pl) {
            return null;
        }
        // 2.当前的根
        int rootVal = postorder[pr];
        TreeNode root = new TreeNode(rootVal);
        int inRootIndex = il;
        // 找到中序序列里根的下标
        for (int i = il; i <= ir; i++) {
            if (inorder[i] == rootVal) {
                inRootIndex = i;
                break;
            }
        }

        // 3.中序遍历区间已经确定，还需要确定后序的遍历区间
        int postLeftEnd = (inRootIndex - il) + pl - 1;
        int postRightStart = postLeftEnd + 1;

        // 4.分别递归处理左子树和右子树
        TreeNode left = buildTree(inorder, il, inRootIndex - 1, postorder, pl, postLeftEnd);
        TreeNode right = buildTree(inorder, inRootIndex + 1, ir, postorder, postRightStart, pr - 1);
        root.left = left;
        root.right = right;

        return root;
    }


    public static void main(String[] args) {
        {
            BuildTreeViaMiddleAndPostOrder solution = new BuildTreeViaMiddleAndPostOrder();

            int[] inorder = new int[]{
                    9, 3, 15, 20, 7
            };
            int[] postorder = new int[]{
                    9, 15, 7, 20, 3
            };
            TreeNode root = solution.buildTree(inorder, postorder);
            System.out.println(root);
        }

    }

}
