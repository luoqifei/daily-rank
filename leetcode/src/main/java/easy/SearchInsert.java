package easy;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 */
public class SearchInsert {
    /**
     * 普通方法，时间复杂度是O(n)。顺序遍历数组，如果i索引的元素小于等于target，那么i+1或者i就是位置
     *
     * @param nums   不为空
     * @param target 目标数字
     * @return
     */
    public static int iteratorMethod(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                index = nums[i] == target ? i : i + 1;
            }
//            if(nums[i]>=target){//这个更简洁
//                index = i;
//            }
        }
        return index;
    }

    /**
     * 二分查找算法，时间复杂度O(log n).
     *
     * @param nums   不为空
     * @param target
     * @return
     */
    public static int bstMethod(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, 3, 5, 6};
        System.out.println(iteratorMethod(num, 7));
        System.out.println(bstMethod(num, 7));
    }
}
