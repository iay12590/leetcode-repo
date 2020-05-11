package com.warden.leetcode.sliding;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2020/5/1 0001.
 */
public class LongestNorepeatSubstring {

    public static void main(String[] args) {
        System.out.println(new LongestNorepeatSubstring().norepeatSubstring("abjdakhijk"));
    }

    public int norepeatSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> window = new HashSet<>();
        int left = 0;
        int right = 0;
        int len = s.length();
        int res = 0;
        while (right < len) {
            char c = s.charAt(right++);
            if (!window.contains(c)) {
                window.add(c);
                res = Math.max(window.size(), res);
            } else {
                while (left < right) {
                    char r1 = s.charAt(left++);
                    if (r1 == c) {
                        break;
                    } else {
                        window.remove(r1);
                    }
                }
            }
        }
        return res;
    }

}