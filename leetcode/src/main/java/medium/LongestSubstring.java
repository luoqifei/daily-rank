package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 求字符串，无重复元素的最长子串的长度
 * 示例：
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
 * 解法：
 * 用一个窗口存放子串，窗口的左右边界差就是子串长度。
 */
public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;//存放当前所有子串的最大长度
        char[] c = s.toCharArray();//字符串变字符数组
        Set<Character> noDupChars = new HashSet<Character>();//存放窗口无重复字符
        int left = 0, right = 0;//窗口的起止字符位置
        while (left < c.length && right < c.length) {//复杂度O(2N）
            if (noDupChars.contains(c[right])) {//窗口最右边j元素，是否已存在set集合里
                noDupChars.remove(c[left++]);
            } else {
                noDupChars.add(c[right++]);//将右边界元素放入set中
                maxLength = Math.max(maxLength, right - left);//窗口的每次移动，不管左边界，还是右边界，都及时获取最大子串长度j-i，也就是窗口长度
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
