package com.warden.leetcode.array;

import java.util.Arrays;

/**
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/9
 */
public class PlusOne {

	public static void main(String[] args) {
		int[] digits = {9,9,9,9};
		System.out.println(Arrays.toString(new PlusOne().plusOne(digits)));
	}

	public int[] plusOne(int[] digits) {
		int index = digits.length - 1;
		while (true) {
			if (index < 0) {
				//copy
				int[] newDigits = new int[digits.length + 1];
				newDigits[0] = 1;
				return newDigits;
			}
			digits[index]++;
			if (digits[index] == 10) {
				digits[index] = 0;
				index--;
			} else {
				break;
			}
		}
		return digits;
	}
}
