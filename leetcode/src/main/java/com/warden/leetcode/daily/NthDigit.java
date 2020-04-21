package com.warden.leetcode.daily;

/**
 * 面试题44. 数字序列中某一位的数字
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。

 请写一个函数，求任意第n位对应的数字。
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/4/3
 */
public class NthDigit {
	public int findNthDigit(int n) {
		if (n <= 9) {
			return n;
		}
		//得到是第几轮的数据round
		long count = 9;
		int round= 1;
		while (n  > count * round) {
			//当前最大数字
			n -= count * round;
			count *= 10;
			round++;
		}

		//根据round获取数字
		int num = (int)(Math.pow(10, round-1) + n/ round);
		if (n % round == 0) {
			//余数为0时取了下一位，需要退回，比如11时，2/2 = 1 表示取11，实际上需要取10，n=13时取11则正常
			num--;
			return num % 10;
		} else {
			for (int i = 0; i < (round - n % round); i++) {
				num /=10;
			}
			return num % 10;
		}
	}

	public static void main(String[] args) {
		System.out.println(new NthDigit().findNthDigit(10));
	}
}
