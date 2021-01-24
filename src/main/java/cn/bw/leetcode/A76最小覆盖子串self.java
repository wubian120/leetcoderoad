package cn.bw.leetcode;

public class A76最小覆盖子串self {

    public String minWindows(String s, String t) {

        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        int[] tMap = new int[128];

        int right = 0, left = 0;
        //计数
        int count = tchars.length;
        int slen = s.length();
        int minLen = s.length() + 1;

        int l = 0, r = 0;

        for (char c : tchars) {
            tMap[c]++;
        }

        while (right < slen) {
            if (tMap[schars[right]] > 0) {
                count--;
            }
            tMap[schars[right]]--;
            right++;

            //计数为0， 此时 [left，right-1]包含一个解 t
            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    l = left;
                    r = right;
                }

                //从右开始移动 窗口
                tMap[schars[left]]++;
                if (tMap[schars[left]] > 0) {
                    count++;
                }
                left++;
            }

        }

        return minLen == slen + 1 ? "" : s.substring(l, r);
    }


    public static void main(String...args){
        String s = "ADOBECODEBANC";
        String t =  "ABC";

        A76最小覆盖子串self a = new A76最小覆盖子串self();
        String result = a.minWindows(s,t);
        System.out.println(result);

        System.out.println("end");

    }


}
