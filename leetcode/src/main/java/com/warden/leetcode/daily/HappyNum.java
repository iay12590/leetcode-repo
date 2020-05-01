package com.warden.leetcode.daily;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2020/4/30 0030.
 */
public class HappyNum {

    public static void main(String[] args) {
        int num = 19;
        System.out.println(new HappyNum().isHappy2(10));
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int result = n;
        while (result != 1) {
            if (set.contains(result)) {
                return false;
            }
            set.add(result);
            int sum = 0;
            while (result != 0) {
                sum += Math.pow(result % 10, 2);
                result /= 10;
            }
            result = sum;
        }
        return true;
    }

    public boolean isHappy2(int n) {
        int slow = n;
        int fast = n;
        do {
            if (slow == 1 || fast == 1) {
                return true;
            }
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
        } while (slow != fast);
        return slow == 1;
    }

    private int squareSum(int m) {
        int squaresum=0;
        while(m!=0){
            squaresum+=(m%10)*(m%10);
            m/=10;
        }
        return squaresum;
    }

}
