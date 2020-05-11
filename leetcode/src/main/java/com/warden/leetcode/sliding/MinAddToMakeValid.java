package com.warden.leetcode.sliding;

/**
 * 给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。

 从形式上讲，只有满足下面几点之一，括号字符串才是有效的：

 它是一个空字符串，或者
 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
 它可以被写作 (A)，其中 A 是有效字符串。
 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/6
 */
public class MinAddToMakeValid {

	public static void main(String[] args) {
		String s = "()))((";
		System.out.println(new MinAddToMakeValid().minAddToMakeValid(s));
	}

	public int minAddToMakeValid(String S) {
		if (S == null || S.length() >= 0) {
			return 0;
		}
		int result = 0;
		int valid = 0;
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c == '(') {
				valid++;
			} else {
				valid--;
			}
			if (valid < 0) {
				result -= valid;
				valid = 0;
			}
		}
		return result + valid;
	}

}
