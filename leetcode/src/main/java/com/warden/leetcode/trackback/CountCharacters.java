package com.warden.leetcode.trackback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/9
 */
public class CountCharacters {

	public int countCharacters(String[] words, String chars) {

		if (words == null || words.length == 0 || chars == null || chars.length() == 0) {
			return 0;
		}
		int base = 'a';
		int[] charCount = new int[26];
		int res = 0;
		for (int i = 0; i < chars.length(); i++) {
			charCount[chars.charAt(i) - base]++;
		}
		for (String word : words) {
			int[] arr = new int[26];
			boolean match = true;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				arr[c - base]++;
				if (arr[c - base] > charCount[c - base]) {
					match = false;
					break;
				}
			}
			if (match) {
				res += word.length();
			}
		}
		return res;
	}


}
