package com.warden.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/6/8
 */
public class EquationsPossible {

	public static void main(String[] args) {
		String[] equations = {"a==b", "a==c", "a==d", "c!=a"};
		System.out.println(new EquationsPossible().equationsPossible(equations));
	}

	public boolean equationsPossible(String[] equations) {
		int level = 0;
		int[] index = new int[26];
		for (String str : equations) {
			char c0 = str.charAt(0);
			char c1 = str.charAt(1);
			char c3 = str.charAt(3);
			if (c1 == '=') {
				level++;
				int idx1 = index[c0-'a'];
				int idx2 = index[c3-'a'];
				for (int i = 0; i < index.length; i++) {
					int cur = index[i];
					if (cur == 0) {
						if (i == c0-'a' || i == c3-'a') {
							index[i] = level;
						}
					} else if (cur == idx1 || cur == idx2){
						index[i] = level;
					}
				}
			}
		}
		for (String str : equations) {
			char c0 = str.charAt(0);
			char c1 = str.charAt(1);
			char c3 = str.charAt(3);
			if (c1 == '!') {
				int idx1 = index[c0-'a'];
				int idx2 = index[c3-'a'];
				if (idx1 == idx2 && idx1 != 0) {
					return false;
				}
			}
		}
		return true;
	}

}
