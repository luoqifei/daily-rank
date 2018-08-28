package easy;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 示例:
 输入: [-2,1,-3,4,-1,2,1,-5,4],
 输出: 6
 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray {
    public static void main(String[] args) {
        //int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = new int[]{-2,1};
            int i = 1;
            int maxSubSum = nums[0];
            int subSum = nums[0];
            //该解法，核心就是连续子串和，如果小于0，那么加上了现在遍历的数，子和也是更小的。所以遍历过程中，如果子和小于0
            //就让子和等于遍历的这个数，否则子和加上这个遍历值
            while (i<nums.length){//遍历数组每个元素
                if(subSum<0){//如果当前子和小于0
                    subSum = nums[i];//让子和等于这个数，毕竟往后再加N个连续元素，也不需要这部分小于0的子和
                }else {//否则子和加上该元素
                    subSum = subSum+nums[i];
                }

                if(maxSubSum<subSum){//判断当前子和和全局最大子和谁大谁小
                    maxSubSum = subSum;
                }
                i++;
            }
        System.out.println(maxSubSum);
    }
}
