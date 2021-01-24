package cn.bw.leetcode.practices;

public class A10正则表达式匹配 {

    public boolean isMatch(String s, String p){
        if(p.isEmpty()){
            return s.isEmpty();
        }
        boolean fstMath = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0)=='.'));

        if(p.length() >=2 && p.charAt(1) == '*'){
            //
            return (isMatch(s,p.substring(2)) || fstMath&&isMatch(s.substring(1), p));
        }else {
            return


                    fstMath && isMatch(s.substring(1),p.substring(1));
        }
    }

}
