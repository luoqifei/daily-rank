package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和 II
 * 和1的区别就是，结果集的某个元素不能重复用了，这个题难度比1小
 * <p>
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 */
public class CombinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);//先排序
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0 || candidates[0] > target) {//特殊情况处理
            return result;
        }
        List<Integer> tmp = new ArrayList<>();
        getSubSet(result, tmp, 0, target, candidates);//最开始从最小元素开始，差值是target
        return result;
    }

    public static void getSubSet(List<List<Integer>> res, List<Integer> tmp, int index, int remain, int[] nums) {
        //差值三种情况考虑，其实就是遍历到的元素与所需值的差
        if (remain < 0) {//也就是遍历到的元素，比target大，所以停止递归
            return;
        } else if (remain == 0) {//如果这个元素恰好是差值
            List<Integer> r = new ArrayList<>(tmp);
            if (!res.contains(r)) res.add(r);//如果之前无该结果集，加入到结果集，退出本次递归
            return;
        } else {//也就是遍历到这个元素比目标值小，那就加入带定结果集tmp里，继续递归
            for (int i = index; i < nums.length; i++) {
                tmp.add(nums[i]);//将本元素加入带待定结果集中
                //index=i+1,索引后移，而且差值更新
                getSubSet(res, tmp, i + 1, remain - nums[i], nums);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        for (List<Integer> a : combinationSum2(candidates, target)) {
            System.out.println(a.toString());
        }
    }
}
