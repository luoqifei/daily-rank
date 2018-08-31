package easy;

/**
 * 题目略长，但是很简单
 * <p>
 * 移除数组指定值的元素
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 */
public class RemoveElement {
    //通过将遍历到的元素，放到末尾，且将末尾元素放到该位置，用于下一次验证。
    public static int removeElement(int[] nums, int val) {
        int i = 0;//左边陌生元素索引
        int n = nums.length;//末尾陌生元素索引
        while (i < n) {
            if (nums[i] == val) {//如果遍历到的这个元素等于目标值，那就
                nums[i] = nums[n - 1];//将末尾陌生元素覆盖掉这个这个元素
                n--;//末尾元素索引减一，每发现一个匹配的值，都移动n，减去一个匹配值，所以剩余的n就是正确答案
            } else {
                i++;//否则不是目标值，那就将左边索引+1
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,2,6,7,1};
        System.out.println(removeElement(nums,5));
        for (int a: nums) {
            System.out.println(a);
        }
    }
}
