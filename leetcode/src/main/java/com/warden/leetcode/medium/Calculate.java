package com.warden.leetcode.medium;

import java.util.Stack;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/6/1
 */
public class Calculate {


	public static void main(String[] args) {
		String s = "1+2*3/2";
		System.out.println(new Calculate().calculate(s));
	}

	public int calculate(String s) {
		int len = s.length();
		int sum = 0;
		Stack<Integer> q = new Stack<>();
		Stack<Integer> numStack = new Stack<>();
		char sample = '+';
		for (int i = 0; i <= len; i++) {
			char c = getChar(s, i);
			if (isdigit(c)) {
				numStack.add(c - '0');
			} else if (!isSpace(c)) {
				int num = getNum(numStack);
				switch (sample) {
					case '+':
						q.add(num);
						break;
					case '-':
						q.add(-num);
						break;
					case '*':
						q.add(q.pop() * num);
						break;
					case '/':
						q.add(q.pop() /num);
					default:
						break;
				}
				sample = c;
			}
		}
		while (!q.isEmpty()) {
			sum += q.pop();
		}
		return sum;
	}

	private char getChar(String s, int index) {
		if (index == s.length()) {
			return '+';
		}
		return s.charAt(index);
	}

	private boolean isdigit(char c) {
		return c >= '0' && c <= '9';
	}

	private boolean isSpace(char c) {
		return c == ' ';
	}

	private int getNum(Stack<Integer> numStack) {
		int sum = 0;
		int offset = 1;
		while (!numStack.isEmpty()) {
			sum += offset * numStack.pop();
			offset *= 10;
		}
		return sum;
	}

}
