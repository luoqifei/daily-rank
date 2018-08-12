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
        for (int i = 0; i < arr.length; i++) {//遍历数组
            while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()]<=arr[i]){//队列的末尾索引对应的数组元素<= 当前遍历的数组元素
                maxQueue.pollLast();//弹出队列末尾的索引
            }
            maxQueue.addLast(i);//将当前遍历数组索引存入队列
            if(maxQueue.peekFirst() == i - w){//因为索引是递增的0~n-1，如果队首索引与当前遍历的索引差值==w，说明这个索引过期了
                maxQueue.pollFirst();//将队首索引移除
            }
            if(i+1>=w){//若遍历的索引加1大于等于3，那就可以才是获取队首索引对应的元素作为结果集之一存入res数组
                res[index++] = arr[maxQueue.peekFirst()];
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
