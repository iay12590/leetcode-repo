package com.warden.leetcode.easy;

import com.warden.leetcode.common.struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/11
 */
public class IsCousins {

	public boolean isCousins(TreeNode root, int x, int y) {
		if (root == null) {
			return false;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			int count = 0;
			for (int i = 0; i < size; i++) {
				int nc = 0;
				TreeNode node = queue.poll();
				if (node.left != null) {
					if ((node.left.val == x) || (node.left.val == y)) {
						nc++;
					}
					queue.add(node.left);
				}
				if (node.right != null) {
					if (node.right.val == x || node.right.val == y) {
						nc++;
					}
					queue.add(node.right);
				}
				if (nc == 2) {
					return false;
				}
				if ((count = count + nc) == 2) {
					return true;
				}
			}
			if (count == 1) {
				return false;
			}
		}
		return false;
	}

}
