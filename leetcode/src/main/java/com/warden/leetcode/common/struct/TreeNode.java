package com.warden.leetcode.common.struct;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/7
 */
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

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
