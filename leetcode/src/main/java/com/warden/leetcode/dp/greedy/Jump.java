package com.warden.leetcode.dp.greedy;

/**
 * Created by Administrator on 2020/5/2 0002.
 */
public class Jump {

    public static void main(String[] args) {
        int[] nums1 = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};
        System.out.println(new Jump().jumpGame(nums1));
        System.out.println(new Jump().jumpGame(nums2));
        System.out.println(new Jump().jumpGameForDP(nums1));
        System.out.println(new Jump().greedy(nums1));
        System.out.println(new Jump().jumpGameForDP2(nums1));
    }

    public boolean jumpGame(int[] nums) {
        int n = nums.length;
        int fastest = 0;
        for (int i = 0; i < n; i++) {
            fastest = Math.max(fastest, i + nums[i]);
            if (fastest <= i) {
                break;
            }
        }
        return fastest >= n-1;
    }

    /**
     * 求最少需要多少步到最后一个位置
     * @param nums
     * @return
     */
    public int jumpGameForDP(int[] nums) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = nums.length;
        }
        return dp(nums, 0, temp);
    }

    private int dp(int nums[], int index, int[] temp) {
        //表示已经到终点
        if (index >= nums.length -1) {
            return 0;
        }
        if (temp[index] <= nums.length - 1) {
            return temp[index];
        }
        //状态=index,选择：跳n步
        for (int i = 1;i <= nums[index]; i++) {
            //此时子状态还未就绪
            int sub = dp(nums, index+i, temp);
            //选择最小的路径
            temp[index] = Math.min(temp[index], sub + 1);
        }
        return temp[index];
    }

    /**
     * 不使用递归
     */
    public int jumpGameForDP2(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = nums.length;
        }
        temp[n - 1] = 0;
        //状态（index），所在位置，往前遍历
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                int jumpIndex = i + j;
                if (jumpIndex >= n -1) {
                    temp[i] = 1;
                    continue;
                }
                temp[i] = Math.min(temp[jumpIndex] + 1, temp[i]);
            }
        }
        return temp[0];
    }

    public int greedy(int[] nums) {
        int n = nums.length;
        int fastest = 0;
        int jump = 0;
        int end = 0;
        //循环，最后一步不需要跳
        for (int i = 0; i < n - 1; i++) {
            //fastest:从i位置跳最远值和不从i位置跳最远值的最大值
            fastest = Math.max(fastest, i + nums[i]);
            //每次都是挑最远的跳
            //（fastest并不是i位置下最远，而是i状态下最远，可以不经过i位置）
            if (end == i) {
                jump++;
                end = fastest;
            }
        }
        return jump;
    }
}
