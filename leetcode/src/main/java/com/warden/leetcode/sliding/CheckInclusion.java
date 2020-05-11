package com.warden.leetcode.sliding;

import java.util.HashMap;
import java.util.Map;

/**
 * t字符串系列是否在s中（只包含t中字符）
 * Created by Administrator on 2020/5/1 0001.
 */
public class CheckInclusion {

    public static void main(String[] args) {
        String s = "saefefabca";
        String t = "aabcy";
        System.out.println(new CheckInclusion().checkInclusion(s, t));
    }

    private boolean checkInclusion(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        Map<Character, Integer> need = new HashMap<Character, Integer>(t.length());
        Map<Character, Integer> window = new HashMap<Character, Integer>(t.length());
        supplyNeed(t, need);
        int valid = 0;
        int left = 0; int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right++);
            Integer n1 = need.get(c);
            if (n1 != null) {
                Integer w1 = window.getOrDefault(c, 0) + 1;
                if (n1.equals(w1)) {
                    valid++;
                }
                window.put(c, w1);
            }
            while (right - left >= t.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char remove = s.charAt(left++);
                n1 = need.get(remove);
                if (n1 != null) {
                    Integer w1 = window.getOrDefault(remove, 0);
                    //有效数减一
                    if (n1.equals(w1)) {
                        valid--;
                    }
                    window.put(c, w1 -1);
                }

            }
        }
        return false;
    }

    private void supplyNeed(String s, Map<Character, Integer> need) {
        for (int i = 0; i < s.length(); i++) {
            Integer count = need.getOrDefault(s.charAt(i), 0);
            need.put(s.charAt(i), count + 1);
        }
    }
}
