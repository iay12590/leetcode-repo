package com.warden.leetcode.daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * 先访问root再依次访问右节点、左节点
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/4/22
 */
public class RightSideView {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		n1.right = new TreeNode(2);
		List<Integer> result = new RightSideView().rightSideView(n1);
		for (Integer i : result) {
			System.out.println(i);
		}
	}

	public List<Integer> rightSideView(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}
		List<Integer> result = new ArrayList<Integer>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		int size = 1;
		queue.add(root);
		while (size > 0) {
			int temp = size;
			size = 0;
			for (int i = 0; i  < temp; i++) {
				TreeNode node = queue.poll();
				if (i == 0) {
					result.add(node.val);
				}
				if (node.right != null) {
					queue.add(node.right);
					size++;
				}
				if (node.left != null) {
					queue.add(node.left);
					size++;
				}
			}
		}
		return result;
	}



}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
