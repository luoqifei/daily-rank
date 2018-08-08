package algorithms;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 给一个已乱序的数组，数组的值有序后是升序数组，比如，1，3，2，4数组，有序后是1，2，3，4。
 * 给定一个包含1-n的数列，我们通过交换任意两个元素给数列重新排序。求最少需要多少次交换，能把数组排成按1-n递增的顺序，其中，数组长度不超过100。
 */
public class MinMumSwaps {
    static int solve(int[] arr) {
        Map<Integer, Integer> numberToIndex = IntStream.range(0, arr.length).boxed()
                .collect(Collectors.toMap(i -> arr[i], Function.identity()));
//        /**
//         * 首先取得每个值的索引，
//         */
//        HashMap<Integer,Integer> numberToIndex1 = new HashMap<>();
//        for (int i = 0; i < arr.length; i++) {
//            numberToIndex1.put(arr[i],i);
//        }
        int swapNum = 0;
        /**
         * 核心解法，遍历乱序数组每个元素的索引，如果该元素就处于有序数组的索引上，就不需要交换，否则，就将该元素与本该处于这个位置的元素交换
         * 实现：
         * 用一个hashMap存放有序数组元素和它当前的索引
         * 实现一个交换数组元素的方法
         */
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {//因为序列是连续的而且是从1开始，所以如果序列不在有序数组的索引上
                if(!numberToIndex.containsKey(i+1)){//避免给出的数组不是连续的，比如1,3,5,2,4,6,8，缺少一个7，会null point
                    continue;
                }
                int otherIndex = numberToIndex.get(i + 1);//就从有序序列找到该值的索引

                numberToIndex.put(arr[i], otherIndex);//更新索引map 数值的索引
                numberToIndex.put(i + 1, i);//更新索引map 数值的索引

                swap(arr, i, otherIndex);//交换数组

                swapNum++;
            }
        }
        return swapNum;
    }

    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    public static void main(String[] args) {
       // int[] arr = new int[]{2,3,6,1,4,5};
        int[] arr = new int[]{1,3,5,2,4,6,8};
        System.out.println(solve(arr));
    }
}
