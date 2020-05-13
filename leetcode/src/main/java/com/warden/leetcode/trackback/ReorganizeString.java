package com.warden.leetcode.trackback;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 相邻数据不能相同
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/12
 */
public class ReorganizeString {


	public static void main(String[] args) {
		String s = "aab";
		String res = new ReorganizeString().reorganizeString(s);
		System.out.println(res);
	}

	public String reorganizeString(String S) {
		return greedy(S);
	}

	/**
	 * 贪心
	 * @param S
	 * @return
	 */
	private String greedy(String S) {
		if (S == null || S.length() <= 1) {
			return S;
		}
		int[] charCount = new int[26];
		int len = S.length();
		int mid = (len + 1) /2;
		for (int i = 0; i < len; i++) {
			char c = S.charAt(i);
			if (++charCount[c - 'a'] > mid) {
				return "";
			}
		}
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
		});
		for (int i = 0; i < 26; i++) {
			if (charCount[i] == 0) {
				continue;
			}
			int[] arr = {i, charCount[i]};
			queue.add(arr);
		}
		int even = 0;
		int odd = 1;
		char[] res = new char[len];
		while (!queue.isEmpty()) {
			if (queue.size() == 1) {
				int[] lef = queue.poll();
				if (lef[1] > 1) {
					return "";
				}
				res[even] = (char)(lef[0] + 'a');
				break;
			}
			int[] evenArr = queue.poll();
			int[] oddArr = queue.poll();
			res[even] = (char)(evenArr[0] + 'a');
			res[odd] = (char)(oddArr[0] + 'a');
			even+=2;
			odd+=2;
			if (--evenArr[1] > 0) {
				queue.add(evenArr);
			}
			if (--oddArr[1] > 0) {
				queue.add(oddArr);
			}
		}
		return new String(res);
	}


	//回溯，超时
	private String trackback(String S) {
		if (S == null || S.length() <= 1) {
			return S;
		}
		int[] charCount = new int[26];
		int len = S.length();
		int mid = (len + 1) /2;
		for (int i = 0; i < len; i++) {
			char c = S.charAt(i);
			if (++charCount[c - 'a'] > mid) {
				return "";
			}
		}
		LinkedList<Integer> track = new LinkedList<>();
		boolean res = trackback(track, charCount, mid, 0);
		if (!res) {
			return "";
		}
		LinkedList<Integer> evenList = new LinkedList<>();
		for (int i = 0; i < 26; i++) {
			if (charCount[i] == 0) {
				continue;
			}
			if (!track.contains(i)) {
				evenList.add(i);
			}
		}
		char[] chars = new char[len];
		int odd = 0;
		while (track.size() > 0) {
			int index = track.poll();
			for (int i  = 0; i < charCount[index]; i++) {
				chars[odd] = (char)(index + 'a');
				odd+=2;
			}
		}
		int even = 1;
		while (evenList.size() > 0) {
			int index = evenList.poll();
			for (int i  = 0; i < charCount[index]; i++) {
				chars[even] = (char)(index + 'a');
				even+=2;
			}
		}

		return new String(chars);
	}

	private boolean trackback(LinkedList<Integer> track, int[] charCount, int target, int current) {
		int count = current;
		if (track.size() != 0) {
			count += charCount[track.getLast()];
			if (count == target) {
				return true;
			}
			if (count > target) {
				return false;
			}
		}
		for (int i = 0; i < charCount.length; i++) {
			if (track.contains(i) || charCount[i] == 0) {
				continue;
			}
			track.add(i);
			boolean result = trackback(track, charCount, target, count);
			if (result) {
				return true;
			}
			track.removeLast();
		}
		return false;
	}



}
