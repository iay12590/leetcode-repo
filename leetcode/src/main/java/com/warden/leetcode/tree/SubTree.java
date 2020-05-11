package com.warden.leetcode.tree;


import com.warden.leetcode.common.struct.TreeNode;

/**
 * 子树
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/7
 */
public class SubTree {

	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null) {
			return false;
		}
		return isSameTree(s, t) || isSubtree(s.right, t) || isSubtree(s.left, t);
	}

	private boolean isSameTree(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}
		if (s == null || t == null) {
			return false;
		}
		if (s.val != t.val) {
			return false;
		}
		return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
	}

}
