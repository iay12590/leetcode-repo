package com.warden.leetcode.tree;

import com.warden.leetcode.common.struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/9/2
 */
public class PathSum {

	private int total = 0;

	/*
	  5
   4   8
 11   13 4
7 2      5 1
	 */

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(4);
		TreeNode n3 = new TreeNode(8);
		TreeNode n4 = new TreeNode(11);
		TreeNode n5 = new TreeNode(13);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(2);
		TreeNode n9 = new TreeNode(5);
		TreeNode n10 = new TreeNode(1);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n3.left = n5;
		n3.right = n6;
		n4.left = n7;
		n4.right = n8;
		n6.left = n9;
		n6.right = n10;
		System.out.println(new PathSum().pathSum(n1, 22));
	}

	public int pathSum(TreeNode root, int sum) {
		//深度优先遍历 回溯
		//bfs
		this.total = 0;
		Map<Integer, Integer> preMap = new HashMap<>();
		preMap.put(0, 1);
		preorder(root, preMap, 0, sum);

		return total;
	}


	public void preorder(TreeNode node, Map<Integer, Integer> preMap, int pre, int sum) {
		//前序
		if (node == null) {
			return;
		}
		//访问
		int newPre = pre + node.val;
		if (preMap.containsKey(newPre - sum)) {
			total += preMap.get(newPre - sum);
		}
		preMap.put(newPre, preMap.getOrDefault(newPre, 0) + 1);
		preorder(node.left, preMap, newPre, sum);
		preorder(node.right, preMap, newPre, sum);
		preMap.put(newPre, preMap.get(newPre) - 1);
	}

}
