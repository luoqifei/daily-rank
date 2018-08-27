package easy;

import java.util.HashMap;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 示例：
 给定 nums = [2, 7, 11, 15], target = 9
 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]
 */
public class TwoSum {
    /**
     * 该实现时间复杂度是O(N),空间复杂度为O(N).
     * 依赖hashMap数据结构，存放每个元素。
     * 顺序遍历数组元素，求出当前元素与target的差值，同时检查已存在Map中的元素，是否存在这个差值。
     * 为什么向需要考虑已加入Map的数据，是因为，即使后面有target元素，那么在迭代到后面肯定可以找到之前的target，所以一次遍历就够了。
     *
     * @param nums
     * @param target
     * @return
     */
    public static  int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> index = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(index.containsKey(complement)){
                return new int[]{index.get(complement),i};
            }
            index.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7,9,11,23};
        int target = 8;
        for (int a: twoSum(nums,target)) {
            System.out.println("index="+a+",value="+nums[a]);
        }
    }
}
