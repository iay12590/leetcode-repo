package com.warden.leetcode.sliding;

import java.util.HashMap;
import java.util.Map;

/**
 * 对于对于字符串S, T,求S中包含T中全部字符的最短子串
 *
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/4/30
 */
public class MinimumWindowSubstring {

	public static void main(String[] args) {
		String s = "afeafasgesad";
		String t = "afa";
//		System.out.println();
		System.out.println(new MinimumWindowSubstring().sliding(s, t));
	}

	public String sliding(String s, String t) {
		if (s == null || t == null) {
			return null;
		}

		int left = 0; int right = 0;
		int len = s.length();
		int start = 0;
		int ml = Integer.MAX_VALUE;
		int vilad = 0;
		int start = 0;
		int len = Integer.MAX_VALUE;
		Map<Character, Integer> need = new HashMap<Character, Integer>(t.length());
		Map<Character, Integer> window = new HashMap<Character, Integer>(t.length());
		int valid = 0;
		supplyNeed(t, need);
		while (right < len) {
			char c = s.charAt(right++);
			Integer nc = need.get(c);
			if (nc == null) {
				continue;
			}
			Integer wc = window.getOrDefault(c, 0) + 1;
			if (nc.equals(wc)) {
				valid++;
			}

			window.put(c, wc);
			//回退
			while (valid == need.size()) {
				if (right - left < ml) {
					ml = right - left;
					start = left;
				}
				char remove = s.charAt(left++);
				nc = need.get(remove);
				if (nc != null) {
					//不可能为空
					wc = window.get(remove);
					if (nc.equals(wc)) {
						valid--;
					}
					window.put(remove, wc - 1);
				}
			}
		}
		return ml == Integer.MAX_VALUE ? null : s.substring(start, start + ml);
		Map<Character, Integer> window = new HashMap<Character, Integer>(t.length());
		supplyNeed(t, need);


		int left = 0; int right = 0;
		while (right < s.length()) {
			char c = s.charAt(right++);
			Integer needNum = need.get(c);
			if (needNum != null) {
				Integer w1 = window.getOrDefault(c, 0) + 1;
				if (needNum.equals(w1)) {
					vilad++;
				}
				window.put(c, w1);
			}

			while (vilad == need.size()) {
				if (right - left < len) {
					start = left;
					len = right - left;
				}
				char remove = s.charAt(left++);
				Integer n1 = need.get(remove);
				if (n1 != null) {
					Integer currentW1 = window.get(remove);
					if (n1.equals(currentW1)) {
						vilad--;
					}
					window.put(remove, currentW1 - 1);
				}
			}
		}
		return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
	}

	private void supplyNeed(String s, Map<Character, Integer> need) {
		for (int i = 0; i < s.length(); i++) {
			Integer count = need.getOrDefault(s.charAt(i), 0);
			need.put(s.charAt(i), count+1);
		}
	}

}
