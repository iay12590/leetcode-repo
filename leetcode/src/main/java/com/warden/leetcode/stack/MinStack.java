package com.warden.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 最小栈
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/9
 */
public class MinStack {

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());
		System.out.println(minStack.top());
		minStack.pop();
		System.out.println(minStack.getMin());
		System.out.println(minStack.top());
	}

		private Stack<Integer> stack;
		private Stack<Integer> minStack;

		/** initialize your data structure here. */
		public MinStack() {
			stack = new Stack<>();
			minStack = new Stack<>();
		}

		public void push(int x) {
			stack.add(x);
			if (minStack.size() == 0) {
				minStack.add(x);
				return;
			}
			Integer top = minStack.peek();
			if (top > x) {
				minStack.add(x);
			} else {
				minStack.add(top);
			}
		}

		public void pop() {
			if (stack.size() <= 0) {
				return;
			}
			stack.pop();
			minStack.pop();
		}

		public int top() {
			if (stack.size() <= 0) {
				return Integer.MIN_VALUE;
			}
			return stack.peek();
		}

		public int getMin() {
			if (minStack.size() == 0) {
				return Integer.MIN_VALUE;
			}
			return minStack.peek();
		}

}
