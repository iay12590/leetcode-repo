package com.warden.leetcode.easy;

import java.util.Stack;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/6/30
 */
public class CQueue {

	private Stack<Integer> tail;
	private Stack<Integer> head;

	public CQueue() {
		tail = new Stack<>();
		head = new Stack<>();
	}

	public void appendTail(int value) {
		tail.add(value);
	}

	public int deleteHead() {
		if (head.isEmpty()) {
			while (!tail.isEmpty()) {
				head.add(tail.pop());
			}
		}
		if (head.isEmpty()) {
			return -1;
		}
		return head.pop();
	}

}
