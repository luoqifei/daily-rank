package easy.binarySearch;

/**
 * 二分查找
 * https://leetcode-cn.com/problems/binary-search/description/
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 */
public class BinarySearch {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;//定义左指针
        int right = nums.length - 1;//右指针
        while (left <= right) {//当左指针小于等于右边指针
            int mid = (left + right) / 2;//求得左右之间中间的索引
            if (nums[mid] == target) {//如果是目标值
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;//如果mid值小于target，那left指针可以跳过一半的数，进行更新
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.println(search(nums, 9));
    }
}
