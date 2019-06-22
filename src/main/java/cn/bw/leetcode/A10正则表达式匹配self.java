package cn.bw.leetcode;


/***
 * 10 正则表达式匹配
 * https://leetcode-cn.com/problems/regular-expression-matching/
 *
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 */
public class A10正则表达式匹配self {


    /**
     * @param s 给定字符串
     * @param p pattern
     * @return
     */
    public boolean isMatch(String s, String p) {

        //如果p为空， 则返回s是否为空
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean firstMatch = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        //注意是 && , 这个地方错过2次
        if (p.length() >= 2 && p.charAt(1) == '*') {
            //两种情况均可， 第一种， 判断s 与 p.substring(2)后序子串是否匹配，
            //第二种 firstMatch 且 s.substring(1)与 p 是否匹配。
            return (isMatch(s, p.substring(2)) || firstMatch && isMatch(s.substring(1), p));
        }else {
            // p.len >=2  but p.charAt(1) != '*'
            //注意 firstMatch 需要在前
            return  firstMatch && isMatch(s.substring(1),p.substring(1));
        }

    }


}
