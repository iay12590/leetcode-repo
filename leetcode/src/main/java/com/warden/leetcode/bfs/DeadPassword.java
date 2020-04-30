package com.warden.leetcode.bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * 带死信密码最短路径 从0000开始到1234最短路径
 * 其中0100，0200，0210不能经过
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/4/29
 */
public class DeadPassword {

	private static final char[] TEMP_CHAR = {'0','1','2','3','4','5','6','7','8','9'};

	private static final short ZERO = 48;

	public static void main(String[] args) {
		String password = "0003";
		String[] dead = new String[]{"0100","0200","0210"};
		System.out.println(new DeadPassword().deadPassword(dead, password));
	}

	private int deadPassword(String[] deadPasswords, String password) {
		Queue<String> queue = new LinkedList<String>();
		Set<String> visit = new HashSet<String>();
		visit.addAll(Arrays.asList(deadPasswords));
		if (visit.contains(password)) {
			return -1;
		}
		String start = getStart(password);
		queue.add(start);
		visit.add(start);
		int step = 0;
		while (!queue.isEmpty()) {

			int size = queue.size();
			for (int j = 0; j < size; j++) {
				String cur = queue.poll();
				if (cur.equals(password)) {
					return step;
				}
				//发散,一次只能转动一个，且只能网上转动
				for (int i = 0; i < cur.length(); i++) {
					String newStr = up(cur, i);
					if (visit.contains(newStr)) {
						continue;
					}
					visit.add(newStr);
					queue.add(newStr);
				}
			}
			step++;
		}
		return -1;
	}

	private String up(String cur, int index) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cur.length(); i++) {
			char c = cur.charAt(i);
			if (i == index) {
				int s = (short) c - ZERO + 1;
				if (s > 9) {
					s = 0;
				}
				c = TEMP_CHAR[s];
			}
			sb.append(c);
		}
		return sb.toString();
	}

	private String getStart(String password) {
		StringBuilder sb = new StringBuilder(password.length());
		for (int i = 0; i < password.length(); i++) {
			sb.append('0');
		}
		return sb.toString();
	}



}
