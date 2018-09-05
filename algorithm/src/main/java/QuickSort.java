public class QuickSort {
    /**
     * 基于某个基准元素，进行快速排序，最后结果是，比基准元素小的都在左边，比它大的都在右边。
     * 相当于这次排序后，基准元素的位置是固定了。
     * 以下代码注释，是基于csdn这位大神这个文章的理解实现
     *
     * @param arr
     * @param left
     * @param right
     * @return
     * @see <a href="https://blog.csdn.net/MoreWindows/article/details/6684558">白话快速排序</a>
     */
    public int adJustArray(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int base = arr[i];//挖坑，将这个数先取出，待会移动i，j指针去填坑
        while (i < j) {//开始一次次遍历，找到合适的数去填坑、以及挖坑

            //开始做最right边找一个比坑小或者等于的数填进来
            while (i < j && arr[j] >= base) {//记住，这里是用base，而不是arr[i]
                j--;//如果➡右指针的数比坑里的数大，那就不交换，直接继续移动寻找
            }
            //找到了一个arr[j]比坑小,或者说i等于j啦，跳出了while循环
            if (i < j) {//判断一下，是i小于j，才赋值填坑
                arr[i] = arr[j];//这样，j这边就有一个坑，需要左指针移动，找一个比坑的数大的填进来
                i++;
            }

            //开始做最left边移动，找一个比坑大的数填进去
            while (i < j && arr[i] < base) {//记住，这里是用base，
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];//将i填入j后，i这里就是一个新的坑
                j--;//需要移动j来填
            }
        }
        //while 循环结束时候，i==j
        //基准base就放入i位置这个坑，固定下来
        arr[i] = base;
        return i;
    }

    //分治法
    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int newBase = adJustArray(arr, left, right);//执行一次挖坑调整排序，将newbase这个元素固定下来。
            //接下来，递归左边的、右边的数
            quickSort(arr, left, newBase - 1);
            quickSort(arr, newBase + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{6,23,57,2,8,6,9};
        QuickSort quickSort= new QuickSort();
        quickSort.quickSort(a,0,a.length-1);
        for (int i: a) {
            System.out.println(i);
        }
    }
}
