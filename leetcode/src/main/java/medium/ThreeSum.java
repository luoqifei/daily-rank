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
    /**
     * 以下这个解法，很简洁。利用了list的contains方法进行去重。不需要做重复元素位移处理，很好理解
     * 但是这个解法由于list contains效率不高，在leetcode是超时的，无法通过。在main方法实现的是可以通过的。
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums){
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
                }
                //依赖sum 的大小判断是sum大于0还是小于0来调整left，right的大小位置，否则while死循环了
                if (sum <= 0) {//等于0，左边界也要加1
                    left++;
                }else {
                    right--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, -1, -1, 0};
        //Integer[] nums = new Integer[]{-2,0,1,1,2};
        //Integer[] nums = new Integer[]{-1, 0, 1, 2, -1, -4};
        Arrays.sort(nums);//必须排序，排序左右夹击才高效
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;//基准元素右边第一个作为左边界
            int right = nums.length - 1;//排序后，数组最后一个
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                /**
                 * 根据sum与0的三种关系进行处理
                 */
                if (sum == 0) {//1******  如果这三个数和为0，就是我们要找的元组
                    List<Integer> tmp = new LinkedList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    res.add(tmp);//1.1 这里不需要判断去重，因为已排好序，只要后续做好左右边界去重移动
                    left++;//1.2 左边界先加一，并且判断加后，是否和上一次相等，若相等继续加一
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    right--;//1.3 不管怎样，右边界直接减一，无需再和left一样处理；
                } else if (sum < 0) {//2***** 小于0，那就是现在的左边界的值不够大，需要后移，但是不能和上一次那个相等
                    left++;//2.1 左边界先加一，并且判断加后，是否和上一次相等，若相等继续加一
                    while (left < right && nums[left] == nums[left - 1]) {//这块可以写成do while
                        left++;
                    }
                } else {//3***** 大于0，右边界移动变小
                    right--;
                }
            }
            while (i + 1 < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;//基准元素也是要做去重位移
            }
        }
        System.out.println(res.toString());
    }
}
