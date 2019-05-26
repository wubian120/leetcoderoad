package cn.bw.leetcode.practices;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 22 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * @auther: bian.wu
 * @date: 2019/5/6 18:56
 */
public class A22_one {

    public List<String> generateParenthesis(int n){

        List<String> results = new LinkedList<>();

        generate(results,"",n,n);

        return results;
    }

    private void generate(List<String> results, String tmp, int left, int right){
        if(left==0&&right==0){
            results.add(tmp);
        }

        if(left>0){
            generate(results,tmp+"(",left-1,right);
        }
        if(right > left){
            generate(results, tmp+")", left, right-1);
        }

    }


}
