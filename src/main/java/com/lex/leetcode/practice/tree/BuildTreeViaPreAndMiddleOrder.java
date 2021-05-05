package com.lex.leetcode.practice.tree;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 中等
 *
 * @author lifeng
 */
public class BuildTreeViaPreAndMiddleOrder {

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
     * 1.先根据前序找到根节点
     * 2.根据中序，找到左子树和右子树分别进行递归处理
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int pl, int pr, int[] inorder, int il, int ir) {

        if (pl >= preorder.length || pr < pl) {
            return null;
        }
        int rootVal = preorder[pl];
        TreeNode root = new TreeNode(rootVal);
        // 1.找到中序里的根节点，方便确定中序左子树区间
        int inRootIdx = il;
        while (inRootIdx < inorder.length && inorder[inRootIdx] != rootVal) {
            inRootIdx++;
        }

        // 确定前序里的遍历区间
        int leftChildLen = inRootIdx - il;
        TreeNode lchild = buildTree(preorder, pl + 1, pl + leftChildLen, inorder, il, inRootIdx - 1);
        root.left = lchild;

        // 2.剩下的是右子树
        TreeNode rchild = buildTree(preorder, pl + leftChildLen + 1, pr, inorder, inRootIdx + 1, ir);
        root.right = rchild;

        return root;
    }

    public static void main(String[] args) {
        {
            BuildTreeViaPreAndMiddleOrder solution = new BuildTreeViaPreAndMiddleOrder();

            int[] preorder = new int[]{
                    3, 9, 20, 15, 7
            };
            int[] inorder = new int[]{
                    9, 3, 15, 20, 7
            };
            TreeNode root = solution.buildTree(preorder, inorder);
            System.out.println(root);
        }

    }

}
