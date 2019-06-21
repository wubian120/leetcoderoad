package cn.bw.leetcode;

import java.util.HashMap;
import java.util.Map;

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

    // 英文官方答案
    public String minWindow0(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        //保存t中所有唯一字符计数的字典。
        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        // t中的唯一字符数，需要出现在所需的窗口中。
        int required = dictT.size();
        // 左 右 指针
        int l = 0, r = 0;
    /*
    formed 用于跟踪当前窗口中以其所需频率存在多少个唯一字符。
    例如 如果t是“AABC”那么窗口必须有两个A，一个B和一个C.
    因此，当满足所有这些条件时，formed = 3。
    */
        int formed = 0;
        // 字典，用于保存当前窗口中所有唯一字符的计数。
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();
        // (窗口长度, 左指针, 右指针)
        int[] ans = {-1, 0, 0};
        while (r < s.length()) {
            // 从右侧向窗口添加一个字符
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);
            //如果添加的当前字符的频率等于t中的所需计数，则将formed增加1。
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }
            // 尝试并收缩窗口，直到它不再是“理想的”。
            while (l <= r && formed == required) {
                c = s.charAt(l);
                // 更新满足条件的最小的窗口和 l r 指针
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                //Left”指针指向的位置处的字符不再是窗口的一部分。
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }
                // 将左指针向前移动，这将有助于查找新窗口。
                l++;
            }
            // 继续扩大窗口
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

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
     * @beat 95%
     * @param s
     * @param t
     * @return
     */
    public String minWindows1(String s, String t) {
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


    /***
     * another
     * @param s
     * @param count
     */
    private void fillEntries(String s, int[] count) {
        for (char c : s.toCharArray())
            count[c]++;
    }

    public String minWindow3(String s, String t) {
        int[] need = new int[128];
        fillEntries(t, need);

        int i = 0, j = 0, l = 0, r = 0, missing = t.length();
        while (r < s.length()) {
            char right = s.charAt(r);
            if (need[right] > 0) missing -= 1;
            need[right]--;
            r += 1;
            while (missing == 0) {
                if (j == 0 || (r - l) < (j - i)) {
                    j = r;
                    i = l;
                }
                char left = s.charAt(l);
                need[left]++;
                if (need[left] > 0) missing += 1;
                l += 1;
            }
        }
        return s.substring(i, j);
    }

    public static void main(String... args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        A76最小覆盖子串 a = new A76最小覆盖子串();
//        String result = a.minWindwos(s,t);

        String result = a.minWindows1(s, t);

        System.out.println(result);
        System.out.println("end");
    }

}
