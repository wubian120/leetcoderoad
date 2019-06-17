package cn.bw.leetcode;

/***
 * 76最小覆盖子串
 *
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://leetcode-cn.com/problems/minimum-window-substring/submissions/
 */
public class A76最小覆盖子串 {

    public String minWindow(String s, String t) {

        int[] ta = new int[128];
        int[] sa = new int[128];
        int min = Integer.MAX_VALUE;
        String minwin = "";
        for (int i = 0; i < t.length(); i++) {
            ta[t.charAt(i)]++;
        }
        int count = 0;
        int end = 0;
        int start = 0;
        while (end < s.length()) {
            if (ta[s.charAt(end)] != 0) {
                if (sa[s.charAt(end)] < ta[s.charAt(end)]) {
                    count++;
                }
                sa[s.charAt(end)]++;
            }
            if (count == t.length()) {
                while (ta[s.charAt(start)] == 0 || sa[s.charAt(start)] > ta[s.charAt(start)]) {
                    if (sa[s.charAt(start)] > ta[s.charAt(start)]) {
                        sa[s.charAt(start)]--;
                    }
                    start++;
                }
                if (end - start + 1 < min) {
                    minwin = s.substring(start, end + 1);
                    min = end - start + 1;
                }
            }
            end++;
        }
        return minwin;
    }

    /***
     * @beat  95%
     * @param s
     * @param t
     * @return
     */
    public String minWindwos(String s, String t) {
        // sChars 中 找 包含 pChars 的最小子串

        char[] sChars = s.toCharArray();
        char[] pChars = t.toCharArray();
        //why  128 ?
        int[] pMap = new int[128];

        int i = 0, j = 0; // 考察窗口[i,j-1]
        int count = pChars.length;
        int minLen = s.length() + 1, l = 0, r = 0;

        for (char pChar : pChars)
            pMap[pChar]++;

        while (j < sChars.length) {
            //减小计数
            if (pMap[sChars[j]] > 0)
                count--;
            pMap[sChars[j]]--;
            j++;
            //计数为 0说明区间[i,j-1] 包含 p
            while (count == 0) {
                //求得一个解
                if (j - i < minLen) {
                    minLen = j - i;
                    l = i;
                    r = j;
                }
                pMap[sChars[i]]++;
                // 增加计数
                if (pMap[sChars[i]] > 0)
                    count++;
                i++;
            }
        }
        return minLen == s.length() + 1 ? "" : s.substring(l, r);
    }


}
