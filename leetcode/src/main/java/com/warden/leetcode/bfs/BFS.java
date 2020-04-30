package com.warden.leetcode.bfs;

import com.warden.leetcode.common.struct.BFSNode;
import com.warden.leetcode.common.struct.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/4/29
 */
public class BFS {

	public static void main(String[] args) {
		//n1 -> n2, n3
		//n2 -> n5
		//n3 -> n4 -> n1, n5
		BFSNode n1 = new BFSNode(1);
		BFSNode n2 = new BFSNode(2);
		BFSNode n3 = new BFSNode(3);
		BFSNode n4 = new BFSNode(4);
		BFSNode n5 = new BFSNode(5);
		n1.setNeibor(new BFSNode[]{n2, n3});
		n2.setNeibor(new BFSNode[]{n5});
		n3.setNeibor(new BFSNode[]{n4});
		n4.setNeibor(new BFSNode[]{n1, n5});
		n5.setNeibor(new BFSNode[]{n2});

		System.out.println(new BFS().bfs(n1, n5));
	}

	/**
	 * 	从起点到终点最短路径
	 */
	public int bfs(Node start, Node end) {
		Queue<Node> q = new LinkedList<Node>();
		Set<Node> visit = new HashSet<Node>();
		int step = 0;
		q.add(start);
		visit.add(start);
		while (!q.isEmpty()) {
			int size = q.size();
			//遍历当前下一步能够到达的节点
			for (int i = 0; i < size; i++) {
				Node cur = q.poll();
				//是否是结果(根据需求定)
				if (cur == end) {
					return step;
				}
				//向四周扩散
				for (Node newNode : cur.abj()) {
					//防止走重复路
					if (visit.contains(newNode)) {
						continue;
					}
					visit.add(newNode);
					q.add(newNode);
				}
			}
			step++;
		}
		return -1;
	}
}
