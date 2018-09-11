package medium.binarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * 返回 true.
 * <p>
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * 返回 false.
 */
public class IsSubsequence {
    public static boolean isSubSequence(String s, String t) {
        //贪心算法，只需要保证s的每个字符在t中，且索引是递增的,也就是遍历t字符串，查找子串是否存在
        int sIndex = 0;
        int tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            if (t.charAt(tIndex) == s.charAt(sIndex)) {
                sIndex++;//只有在母串找到了子串的字符，才递增子串的索引
            }
            tIndex++;//在循环中，t的索引每次都增加，所以算法的复杂度是o(N)。
        }
        return sIndex == s.length();//如果长度相等，就是子串
    }
    /**
     * 后续挑战 :
     *
     * 如果有大量输入的 S，称作S1, S2, ... ,
     * Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码
     */
    /**
     * 这个就使用二分查找算法了
     * 先记着母串t中的所有字符的索引，存入list结构。基于字符值存入索引，list[字符]=索引i
     */
    public static boolean isSubSequence2(String s, String t) {
        //特殊情况判断处理
        if (s.length() == 0) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }
        //只有256个字符，所以这个链表数组就定义256即可
        List<Integer>[] list = new List[256];
        for (int i = 0; i < t.length(); i++) {//遍历母串t
            char c = t.charAt(i);//取得索引i，的字符c
            if (list[c] == null) {//如果这个字符，未曾有过记录
                list[c] = new ArrayList<Integer>();
            }
            list[c].add(i);
        }
        int preIndex = -1;
        for (int i = 0; i < s.length(); i++) {//遍历子串，判断是否在母串
            char c = s.charAt(i);
            if (list[c] == null) return false;//如果子串的字符，在母串不存在
            int index = binarySearch(list[c], preIndex + 1);
            if (index == -1) return false;
            else preIndex = index;
        }
        return true;
    }

    public static int binarySearch(List<Integer> list, int key) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (key > list.get(mid)) left = mid + 1;
            else right = mid;
        }
        if (list.get(right) < key) return -1;
        return list.get(right);
    }
}
