package easy;

import java.util.ArrayList;

/**
 * 两个数组的交集 II
 *
 * @see <a herf="https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/description/">leetcode两个数组的交集 II </a>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 */
public class Intersect2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        //利用list的结构indexof来删除链表指定位置的值
        ArrayList<Integer> list = new ArrayList<>();
        for (int a : nums1) {
            list.add(a);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int b : nums2) {
            int i = list.indexOf(b);
            if (i != -1) {
                list.remove(i);
                res.add(b);
            }
        }
        int[] r = new int[res.size()];
        int j = 0;
        for (int c : res) {
            r[j++] = c;
        }
        return r;
    }
}
