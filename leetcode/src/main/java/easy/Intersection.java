package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 两个数组的交集
 *
 * @see <a href="https://leetcode-cn.com/problems/intersection-of-two-arrays/description/">leetcode 两个数组的交集</a>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Intersection {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> num1Set = new HashSet<>();//先将数组1的所有元素放入set，通过set直接去重
        for (int n : nums1) {
            num1Set.add(n);
        }
        Set<Integer> res = new HashSet<>();//因为结果集元素也需要去重，用res set暂存结果
        for (int m : nums2) {
            if (num1Set.contains(m)) {
                res.add(m);
            }
        }
        int i = 0;
        int[] r = new int[res.size()];
        for (int s : res) {
            r[i++] = s;
        }
        return r;
    }
}
