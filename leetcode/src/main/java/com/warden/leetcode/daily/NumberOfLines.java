package com.warden.leetcode.daily;

import java.util.Arrays;

/**
 * 我们要把给定的字符串 S 从左到右写到每一行上，每一行的最大宽度为100个单位，
 * 如果我们在写某个字母的时候会使这行超过了100 个单位，那么我们应该把这个字母写到下一行。
 * 我们给定了一个数组 widths ，这个数组 widths[0] 代表 'a' 需要的单位，
 * widths[1] 代表 'b' 需要的单位，...， widths[25] 代表 'z' 需要的单位。

 现在回答两个问题：至少多少行能放下S，以及最后一行使用的宽度是多少个单位？将你的答案作为长度为2的整数列表返回。
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/4/7
 */
public class NumberOfLines {
	public int[] numberOfLines(int[] widths, String S) {
		int max = 100;
		int current = 0;
		int line = 1;
		for (int i = 0; i < S.length(); i++) {
			int index = S.charAt(i) - 97;
			if (widths[index] + current > max) {
				line ++;
				current = 0;
			}
			current += widths[index];
		}
		return new int[]{line, current};
	}

	public static void main(String[] args) {
		int[] width = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
		String s = "bbbcccdddaaa";
		System.out.println(Arrays.toString(new NumberOfLines().numberOfLines(width, s)));
	}
}
