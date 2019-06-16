package cn.bw.leetcode;

/***
 * 76最小覆盖子串
 * https://leetcode-cn.com/problems/minimum-window-substring/submissions/
 */
public class A76最小覆盖子串 {

    public String minWindow(String s, String t) {
        int[] ta = new int[128];
        int[] sa = new int[128];
        int min = Integer.MAX_VALUE;
        String minwin = "";
        for(int i = 0; i<t.length(); i++){
            ta[t.charAt(i)]++;
        }
        int count = 0; int end = 0; int start = 0;
        while(end < s.length()){
            if(ta[s.charAt(end)] != 0){
                if(sa[s.charAt(end)] < ta[s.charAt(end)]){
                    count++;
                }
                sa[s.charAt(end)]++;
            }
            if(count == t.length()){
                while(ta[s.charAt(start)] == 0 || sa[s.charAt(start)] > ta[s.charAt(start)]){
                    if(sa[s.charAt(start)] > ta[s.charAt(start)]){
                        sa[s.charAt(start)]--;
                    }
                    start++;
                }
                if(end-start+1 < min){
                    minwin = s.substring(start,end+1);
                    min = end-start+1;
                }
            }
            end++;
        }
        return minwin;
    }


}
