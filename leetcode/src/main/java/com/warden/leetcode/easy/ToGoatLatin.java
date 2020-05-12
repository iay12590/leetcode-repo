package com.warden.leetcode.easy;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.HashSet;
import java.util.Set;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/11
 */
public class ToGoatLatin {

	private static final Set<Character> VOWEL_SET = new HashSet<>();

	static {
		VOWEL_SET.add('a');
		VOWEL_SET.add('e');
		VOWEL_SET.add('i');
		VOWEL_SET.add('o');
		VOWEL_SET.add('u');
		VOWEL_SET.add('A');
		VOWEL_SET.add('E');
		VOWEL_SET.add('I');
		VOWEL_SET.add('O');
		VOWEL_SET.add('U');
	}

	public static void main(String[] args) {
		String s = "I speak Goat Latin";
		System.out.println(new ToGoatLatin().toGoatLatin(s));
	}

	public String toGoatLatin(String S) {
		if (S == null || S.length() == 0) {
			return S;
		}
		int len = S.length();
		String[] words = S.split(" ");
		int wLen = words.length;
		//预分配words.len + S.len
		int sLen = wLen + (3+len) * len  / 2 + 1;
		StringBuilder sb = new StringBuilder(sLen);
		for (int i = 0; i < wLen; i++) {
			String word = words[i];
			int start = 0;
			if (VOWEL_SET.contains(word.charAt(0))) {
				start++;
			}
			int t = start + word.length();
			for (int j = start; j < t; j++) {
				sb.append(word.charAt(j%word.length()));
			}
			sb.append("ma");
			for (int j = 0; j < i+1; j++) {
				sb.append('a');
			}
			if (i != wLen - 1) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}
}
