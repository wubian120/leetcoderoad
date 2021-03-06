package cn.bw.leetcode;

/**
 * @description: 14 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 *
 * @auther: bian.wu
 * @date: 2019/4/26 10:01
 */
public class A14最长公共前缀 {

    /***
     * @beat 99%
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs){
        String prefix="";
        int len = strs.length;
        if(len>0){
            prefix = strs[0];
        }
        for(int i=0;i<len;i++){
            while (!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0,prefix.length()-1);
            }
        }

        return prefix;
    }
}
