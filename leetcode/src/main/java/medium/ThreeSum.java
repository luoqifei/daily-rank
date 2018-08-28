package medium;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{-1, 0, 1,-1, 0, 1, 2, -1, -4};
        Arrays.sort(nums);//必须排序，排序左右夹击才高效
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;//基准元素右边第一个作为左边界
            int right = nums.length - 1;//排序后，数组最后一个
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {//如果这三个数和为0，就是我们要找的元组，剩下就是去重操作了
                    List<Integer> tmp = new LinkedList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    if (!res.contains(tmp)) {//去重
                        res.add(tmp);
                    }
                    break;
                }
                //依赖sum 的大小判断是sum大于0还是小于0来调整left，right的大小位置，否则while死循环了
                if (sum <= 0) {//等于0，左边界也要加1
                    left++;
                }else {
                    right--;
                }
            }
        }
        System.out.println(res.toString());
    }
}
