package algorithms;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 有一个长度为n的整型数组arr 和一个大小为w 的窗口从数组的最左边滑到最右边，窗口每次向右滑动一个位置，求每个窗口所含arr元素的最大值
 * 比如4，5，1，6，7数组，w=3，那么结果就是5，6，7
 * 第一个窗口就是，4，5，1，最大值就是5
 * 第二个窗口就是5，1，6，最大值是6
 * 第三个窗口就是1，6，7，最大值就是7
 * 解法有很多种，比如时间复杂度为O(n*w),遍历数组，并计算窗口w的最大值
 * 比如使用某种排序方法，取asc排序后的数组最后n-w+1 个元素，就是所要的乱序结果集，根据数组索引排序结果输出
 * 如下使用双端队列，时间复杂度是o(n)
 */
public class MaxWindow {
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,6,2,7,8};
        int w = 3;
        LinkedList<Integer> maxQueue = new LinkedList<>();
        int[] res = new int[arr.length-w+1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()]<=arr[i]){
                maxQueue.pollLast();
            }
            maxQueue.addLast(i);
            if(maxQueue.peekFirst() == i - w){
                maxQueue.pollFirst();
            }
            if(i+1>=w){
                res[index++] = arr[maxQueue.peekFirst()];
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
