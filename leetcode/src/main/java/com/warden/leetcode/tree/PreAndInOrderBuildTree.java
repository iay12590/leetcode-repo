package com.warden.leetcode.tree;

import com.warden.leetcode.common.struct.TreeNode;

/**
 * 根据前序遍历和中序遍历构造树
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/22
 */
public class PreAndInOrderBuildTree {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0) {
			return null;
		}
		int len = preorder.length;
		return buildTree(preorder, inorder, 0, len - 1, 0, len -1);
	}

	private TreeNode buildTree(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
		if (pl > pr || il > ir) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[pl]);
		int t = il;
		while (inorder[t] != preorder[pl]) {
			t++;
		}
		int leftLen = t - il;
		root.left = buildTree(preorder, inorder, pl + 1, pl + leftLen, il, t - 1);
		root.right = buildTree(preorder, inorder, pl + leftLen + 1, pr, t + 1, ir);
		return root;
	}

}
