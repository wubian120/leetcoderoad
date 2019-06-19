package cn.bw.leetcode.practices;

/**
 * 10.正则表达式匹配
 */
public class A10one {


    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean fstMatch = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2)) || fstMatch && isMatch(s.substring(1), p));
        } else {
            return fstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

}
