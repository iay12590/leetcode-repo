package com.warden.leetcode.sort2;

import java.util.Arrays;

/**
 * Created by Administrator on 2020/5/10 0010.
 */
public class MaximumProduct {

    public static void main(String[] args) {
        int[] nums = {1,2,3,2};
        System.out.println(new MaximumProduct().maximumProduct(nums));
    }

    public int maximumProduct(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < 3; i++) {
            int max = i;
            int min = i;
            for (int j = i; j < nums.length - i; j++) {
                if (nums[j] > nums[max]) {
                    max = j;
                }
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (max== min) {
                break;
            } else {
                exchange(nums, max, i);
                if (i == min) {
                    min = max;
                }
                exchange(nums, min, nums.length - i - 1);
            }
        }
        return Math.max(nums[0] * nums[1] * nums[2], nums[0] * nums[len - 1] * nums[len - 2]);
    }

    private void exchange(int[] nums, int i, int j ) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
