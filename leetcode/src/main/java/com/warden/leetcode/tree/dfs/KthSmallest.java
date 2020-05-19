package com.warden.leetcode.tree.dfs;

import com.warden.leetcode.common.struct.TreeNode;

/**
 * 第k个最小值
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/14
 */
public class KthSmallest {

	public int kthSmallest(TreeNode root, int k) {
		Result result = new Result();
		inorderTraversal(root, k, result);
		return result.node.val;
	}

	private void inorderTraversal(TreeNode root, int k, Result result) {
		if (root.left != null) {
			inorderTraversal(root, k, result);
		}
		if (result.count == k) {
			return;
		}
		result.count ++;
		if (++result.count == k) {
			result.node = root;
		}
		inorderTraversal(root, k, result);
	}

	private static class Result{
		int count;
		TreeNode node;
	}

}

