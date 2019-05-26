package cn.bw.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 3. 无重复字符串的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @auther: bian.wu
 * @date: 2019/4/24 17:34
 */
public class A3无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s){

        int result = 0, front=0, current=0, len = s.length();
        Set<Character> charSet = new HashSet<>();
        while (front<len && current<len){

            if(!charSet.contains(s.charAt(current))){
                charSet.add(s.charAt(current++));
                result = Math.max(result, current-front);
            }else {
                charSet.remove(front++);
            }
        }




        return result;
    }



}
