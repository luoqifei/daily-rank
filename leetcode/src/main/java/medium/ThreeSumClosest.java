package medium;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        //先排序
        Arrays.sort(nums);
        //遍历有序数组，定义左右边界，求每个元素的三元组和，只取最接近target的三元组和
        if (nums.length < 3) {
            throw new IllegalArgumentException("array length less than 3");
        } else if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        int closestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (target == sum) {//如果sum和target相等直接返回结果，跳出计算
                    return sum;
                } else {//否则根据距离差进行位移
                    if (Math.abs(target - sum) < Math.abs(target - closestSum)) {//取绝对值做差值距离
                        closestSum = sum;
                    }
                    if (sum < target) {//如果这个sum比target小，那还可以继续往后移动，加大sum
                        do {
                            left++;
                        } while (left < right && nums[left] == nums[left - 1]);//跳过重复的值
                    } else {
                        do {
                            right--;
                        } while (left < right && nums[right] == nums[right + 1]);//跳过重复的值
                    }
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {//跳过重复的值
                i++;
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        //[0,2,1,-3]
        //int[] nums = new int[]{1, 2, 4, 8, 16, 32, 64, 128};
        System.out.println(threeSumClosest(nums, 1));
    }
}
