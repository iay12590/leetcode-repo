package com.warden.leetcode.easy;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/6/23
 */
public class AddBinary {

	public static void main(String[] args) {
		String a = "1";
		String b = "111";
		System.out.println(new AddBinary().addBinary(a, b));
	}

	public String addBinary(String a, String b) {
		int lena = a.length();
		int lenb = b.length();
		int len = Math.max(lena, lenb);
		StringBuilder sb = new StringBuilder(len + 1);
		int inc = 0;
		for (int i = 0; i < len; i++) {
			int c1 = getValue(a, i);
			int c2 = getValue(b, i);
			int v = c1 + c2 + inc;
			sb.append(v%2);
			inc = v >> 1;
		}
		if (inc == 1) {
			sb.append(inc);
		}
		return sb.reverse().toString();
	}

	private int getValue(String str, int index) {
		if (index >= str.length()) {
			return 0;
		}
		return str.charAt(str.length() - index - 1) - '0';
	}

}
