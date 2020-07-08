package com.warden.leetcode.tree;

import com.warden.leetcode.common.struct.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/6/16
 */
public class CodecV2 {

		private static final TreeNode NULL_NODE = new TreeNode(-1);

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;
		CodecV2 codec = new CodecV2();
		String s = codec.serialize(n1);
		System.out.println(s);
		TreeNode n =codec.deserialize(s);
		s = codec.serialize(n);
		System.out.println(s);
	}

	public String serialize(TreeNode root) {
		//深度优先遍历
		if (root == null) {
			return "";
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		queue.add(root);
		boolean allNull = false;
		while (!queue.isEmpty() && !allNull) {
			int size = queue.size();
			allNull = true;
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node == NULL_NODE) {
					sb.append(",");
					continue;
				} else {
					sb.append(node.val).append(",");
				}
				TreeNode left = node.left;
				TreeNode right = node.right;
				if (left != null) {
					queue.add(left);
					allNull = false;
				} else {
					queue.add(NULL_NODE);
				}
				if (right != null) {
					queue.add(right);
					allNull = false;
				} else {
					queue.add(NULL_NODE);
				}
			}
		}
		return sb.substring(0, sb.length() - 1);
	}

	public TreeNode deserialize(String data) {
		if (data == null || data.length() <= 0) {
			return null;
		}
		String[] arr = data.split(",");
		LinkedList<TreeNode> queue = new LinkedList<>();
		int index = 0;
		TreeNode root = new TreeNode(Integer.parseInt(arr[index++]));
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				TreeNode left = getNode(arr, index++);
				TreeNode right = getNode(arr, index++);
				node.left = left;
				node.right = right;
				if (left != null) {
					queue.add(left);
				}
				if (right != null) {
					queue.add(right);
				}
			}
		}
		return root;
	}

	private TreeNode getNode(String[] nodeArr, int index) {
		if (index >= nodeArr.length) {
			return null;
		}
		String nodeStr = nodeArr[index];
		if ("".equals(nodeStr)) {
			return null;
		}
		return new TreeNode(Integer.parseInt(nodeStr));
	}

}
