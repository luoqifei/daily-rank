package easy;

/**
 * 删除有序数组的重复元素
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成
 * 示例 1:
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        //双指针法
        //面对一个有序的数组，我们只需将后续的不重复元素，覆盖前面的重复元素即可
        int i = 0;//慢指针，指向的都是非重复元素
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {//如果发现快指针的元素和慢指针的不同
                nums[i + 1] = nums[j];//就让快指针后面的这个元素往前移
                i++;//慢指针往后移
            }else {//如果相等
                //do nothing,其实如果发现有重复元素，那就用快指针跳过，所以j++,然后直到找到不相等的
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,2,3,4,5,6,6,7,8};
        int noneDupNums = removeDuplicates(nums);
        for (int a=0;a<noneDupNums;a++) {
            System.out.println(nums[a]);
        }
    }
}
