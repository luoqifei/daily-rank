package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 candidates 中的数字可以无限制重复被选取。
 说明：
 所有数字（包括 target）都是正整数。
 解集不能包含重复的组合。
 示例 1:
 输入: candidates = [2,3,6,7], target = 7,
 所求解集为:
 [
 [7],
 [2,2,3]
 ]
 * 考虑用回溯法解题。
 * 首先将数组从小到大排序，然后从第一个数字开始遍历，若该数字不大于当前目标值，则将其加入到结果数组中，
 * 然后把目标值减去当前数字，并从当前数字开始向后递归寻找下一个满足上述条件的数字。
 * 若到某一步为止目标值为0，则将当前结果数组加入到集合中。每个数字向后遍历完之后，将其从结果数组中去除，
 * 从下一个数字开始继续寻找，直到走到数组末尾或者没有不大于目标值的数。
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] nums ,int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);//先排序
        if(nums[0]>target || nums.length ==0){//特殊情况处理，最小元素大于target，或者空数组
            return result;
        }
        List<Integer> tmp = new ArrayList<>();//定义一个在回溯计算过程存放中间结果的
        getRemainTarget(nums,result,tmp,0,target);//从第一个元素开始，找以每个排序后元素开头的有效集合
        return result;
    }

    /**
     * 这个实现方式要求，target不能为负数
     * @param nums
     * @param result
     * @param tmp
     * @param start
     * @param remain
     */
    public static void getRemainTarget(int[] nums,List<List<Integer>> result,List<Integer> tmp,int start,int remain){
        /**
         * 三种情况处理
         */
        if(remain<0){//如果该元素，或者说被迭代到的元素大于target，所以就跳出回溯递归
            return;
        }else if(remain == 0){//如果该元素与恰好与target相等，也就是差值为0，那就找到了一个子集了
            result.add(new ArrayList<>(tmp));
            return;
        }else {//这个元素比target小，那还可以继续回溯
            for (int i = start; i < nums.length; i++) {
                tmp.add(nums[i]);//将这个元素加入到待确认的结果集里
                getRemainTarget(nums,result,tmp,i,remain - nums[i]);
                tmp.remove(tmp.size()-1);//不管这个回溯结果是否被加入到结果集，都需要移除
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        for (List<Integer> a: combinationSum(candidates,target)) {
            System.out.println(a.toString());
        }
    }
}
