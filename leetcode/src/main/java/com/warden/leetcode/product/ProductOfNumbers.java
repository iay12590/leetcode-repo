package com.warden.leetcode.product;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回当前数字列表中，最后 k 个数字的乘积。
 你可以假设当前列表中始终 至少 包含 k 个数字。
 题目数据保证：任何时候，任一连续数字序列的乘积都在 32-bit 整数范围内，不会溢出。
 * @author JianHua.Lin
 * @version 1.0.0
 * @date 2020/5/18
 */
public class ProductOfNumbers {

	private int i = 0;

	private int sum = 1;

	private List<Integer> list;

	public static void main(String[] args) {
		//[[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]
		ProductOfNumbers productOfNumbers = new ProductOfNumbers();
		productOfNumbers.add(3);        // [3]
		productOfNumbers.add(0);        // [3,0]
		productOfNumbers.add(2);        // [3,0,2]
		productOfNumbers.add(5);        // [3,0,2,5]
		productOfNumbers.add(4);        // [3,0,2,5,4]
		System.out.println(productOfNumbers.getProduct(2)); // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
		System.out.println(productOfNumbers.getProduct(3)); // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
		System.out.println(productOfNumbers.getProduct(4)); // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
		System.out.println(productOfNumbers.getProduct(2)); // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
		; // 返回 40 。最后 3 个数字的乘积是 2 * 5 * 4 = 40
		; // 返回  0 。最后 4 个数字的乘积是 0 * 2 * 5 * 4 = 0
		productOfNumbers.add(8);        // [3,0,2,5,4,8]
		System.out.println(productOfNumbers.getProduct(2));
		 // 返回 32 。最后 2 个数字的乘积是 4 * 8 = 32
	}

	public ProductOfNumbers() {
		list = new ArrayList<>();
	}

	public void add(int num) {
		sum *= num;
		if (num == 0) {
			i = 0;
			sum = 1;
			list.clear();
		} else {
			i++;
			list.add(sum);
		}
	}

	public int getProduct(int k) {
		if (k > i) {
			return 0;
		}
		//k之前
		int pre = 1;
		if (list.size() - k - 1 >= 0) {
			pre = list.get(list.size() - k - 1);
		}
		return sum / pre;
	}
}
