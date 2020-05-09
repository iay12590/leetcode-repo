package com.warden.leetcode.dp;

/**
 * 分割等和子集
 * 状态压缩：状态数组二维-->一维
 * Created by Administrator on 2020/5/2 0002.
 */
public class StateCompress {

    public static void main(String[] args) {
        int[] nums = {1, 5,5, 11};
        System.out.println(new StateCompress().stateCompress(nums));
    }

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum >>= 1;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i -1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i -1]];
                }
            }
        }
        return dp[nums.length][sum];
    }

    /**
     * 状态压缩：使用i-1推导i的状态，其实只需要保存i-1的状态即可
     * 选择时从后往前遍历，避免推导（i，w) 时w-num[i]并不是i-1的状态，而是在i状态被修改过的
     */
    public boolean stateCompress(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum >>= 1;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] < 0) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }


}
