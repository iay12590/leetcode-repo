package com.warden.leetcode.plalindrome;

/**
 * 最多删除一个形成回文
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/19
 */
public class IsPlalindrome {

	public static void main(String[] args) {
		String s = "abac";
		System.out.println(new IsPlalindrome().validPalindrome(s));
	}

	public boolean validPalindrome(String s) {
		if (s == null) {
			return false;
		}
		int len = s.length();
		if (len <= 1) {
			return true;
		}
		return isPlalindrome(s, 0, len - 1, true);
	}
	public boolean isPlalindrome(String s, int left, int right, boolean delete) {
		if (left >= right) {
			return true;
		}
		while (left < right) {
			if (s.charAt(left) == s.charAt(right)) {
				left++;
				right--;
			} else {
				if (!delete) {
					return false;
				}
				return isPlalindrome(s, left + 1, right, false) || isPlalindrome(s, left, right - 1, false);
			}
		}
		return true;
	}
}
