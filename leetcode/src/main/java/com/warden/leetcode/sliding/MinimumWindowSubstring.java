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

	public String sliding(String s, String t) {
		if (s == null || t == null) {
			return null;
		}

		int left = 0; int right = 0;
		int len = s.length();
		Map<Character, Integer> need = new HashMap<Character, Integer>(t.length());
		supplyNeed(s, need);
	}

	private void supplyNeed(String s, Map<Character, Integer> need) {
		for (int i = 0; i < s.length(); i++) {
			Integer count = need.getOrDefault(s.charAt(i), 0);

		}
	}

}
