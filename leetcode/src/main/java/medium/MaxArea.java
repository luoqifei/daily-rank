package medium;

/**
 * 盛最多水的容器
 *
 * @see <a herf="https://leetcode-cn.com/problems/container-with-most-water/description/"> leetcode 盛最多水的容器</a>
 * 原题描述
 * 因为有图，请直接点开链接看题目描述
 */
public class MaxArea {
    //解题思路：面积=长*宽，比如，我们先取最大的宽度，那么接下来要想得到更大的面积，那就是找一个相对好点的长度。
    //双指针解法的思路，就是先默认取首尾距离最远，也就是宽度最大的两个高度，作为第一个最大面积。两个指针分别指向两个高度
    //得到这个面积后，移动较小的指针，需求一个更大的高度，让面积可能变大。
    public int maxArea(int[] height) {
        int maxArea = 0;//定义最大面积变量，最小默认值是0
        //双指针法
        if (height.length <= 1) {
            return 0;
        }

        int left = 0;//左边指针
        int right = height.length - 1;//最右边指针，两个最远的指针构成宽度最大
        while (left < right) {//开始指针移动遍历
            if(height[left]<=height[right]){//移动高度较小的指针，需求一个更高的
                maxArea = Math.max(maxArea,height[left] * (right-left));//最低高度乘以宽度
                left++;//左指针，高低较低的移动
            }else {
                maxArea = Math.max(maxArea,height[right] * (right-left));
                right--;
            }
        }
        return maxArea;
    }

}
