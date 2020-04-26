package com.warden.leetcode.daily;

import com.warden.leetcode.common.struct.ListNode;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/4/26
 */
public class MergeKlists {

	//[[1,4,5],[1,3,4],[2,6]]

	private static final ListNode MAX = new ListNode(Integer.MAX_VALUE);

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(5);
		ListNode n4 = new ListNode(1);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(4);
		ListNode n7 = new ListNode(2);
		ListNode n8 = new ListNode(6);
		n1.next = n2;
		n2.next = n3;
		n4.next = n5;
		n5.next = n6;
		n7.next = n8;
		ListNode[] lists = {n1,n4, n7};
		ListNode result = new MergeKlists().mergeKLists(lists);
		while (result != null) {
			System.out.print(result.val + ",") ;
			result = result.next;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		createHeap(lists);
		ListNode result = null;
		ListNode current = null;
		while (true) {
			ListNode head = lists[0];
			if (head == MAX) {
				break;
			}
			if (result == null) {
				result = head;
				current = head;
			} else {
				current.next = head;
				current = head;
			}
			ListNode next = head.next;
			head.next = null;
			if (next == null) {
				next = MAX;
			}
			lists[0] = next;
			shiftDown(0, lists);
		}
		return result;
	}
	/**
	 * 最小堆排序
	 */

	private void createHeap(ListNode[] lists) {
		int n = lists.length;
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] == null ) {
				lists[i] = MAX;
			}
		}
		for (int i = (n/2-1); i >= 0; i--) {
			shiftDown(i, lists);
		}
	}

	private void shiftDown(int i, ListNode[] lists) {
		boolean flag = true;
		int index = 0;
		int n = lists.length;
		while (2 * i + 1 < n && flag) {
			//分别判断左节点和右节点(,找出最小值
			if (lists[2 * i + 1].val < lists[i].val) {
				index = 2 * i + 1;
			} else {
				index = i;
			}
			if (2 * i + 2 < (n)) {
				if (lists[2 * i + 2].val < lists[index].val) {
					index = 2 * i + 2;
				}
			}
			if (i == index) {
				flag = false;
			} else {
				swap(i, index, lists);
				i = index;
			}
		}
	}

	private void swap(int i, int j, ListNode[] lists) {
		ListNode temp = lists[i];
		lists[i] = lists[j];
		lists[j] = temp;
	}

}
