package cn.bw.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 22 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * @思路： 回溯
 * @auther: bian.wu
 * @date: 2019/4/24 15:04
 */
public class A22括号生成 {

    public List<String> generateParenthesis(int n) {
        List<String> results = new LinkedList<>();
        int left = n, right = n;
        generate(results, "", left, right);
        return results;
    }

    private void generate(List<String> result, String tmp, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(tmp);
        }
        if (left > 0) {
            generate(result, tmp + "(", left - 1, right);
        }
        if (right > left) {
            generate(result, tmp + ")", left, right - 1);
        }
    }


}
