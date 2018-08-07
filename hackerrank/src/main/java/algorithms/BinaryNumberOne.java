package algorithms;

import java.util.Scanner;

/**
 * 给定一个32位整数，转换成二进制后，含有1的个数
 */
public class BinaryNumberOne {

    /**
     * 计算一个整数，转换成二进制串含有连续1的最多个数
     * 比如5=101，就是1，7=111，就是三个1
     *
     * @param n
     */
    private static void CountConsecutiveOne(int n) {
        int sum = 0, max = 0;
        while (n > 0) {
            if (n % 2 == 1) {//利用十进制数转换成2进制后，除以2，不断向左移，若末尾等于1说明末尾是1，count++，否则就直接设置为0.并且记录这个过程最大的连续1的count
                sum++;//末尾是1 sum+1
                if (sum > max) {
                    max = sum;//利用中间变量max，存最大连续1个数
                }
            } else {//否则是0，那么这次连续1统计结束，归0
                sum = 0;
            }
            n = n / 2;
        }
        System.out.println(max);
    }
    /**
     * 如果将一个二进制数－1，那么该二进制数最右侧的1将会变成0，1后面的0均变成1，1前面的数保持不变。
     * 也就是说，如果一个二进制数－1，那么该数最右侧的1及1右侧的所有数均变成相反数。
     * 如果把这个数和原数与运算，那么最右侧的那个1前面的数将不变，1及1右侧的所有数均变为0。
     * 也就是说，进行一次上述的运算后，原数最右侧的那个1将会变成0，
     * 那么只要重复上述操作，当原数变成0时，循环的次数就是1的个数。
     * <p>
     * 代码如下：
     */
    public static int countBitOne(int n) {
        //n中1的个数
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("please input a integer number ...");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(countBitOne(n));
        CountConsecutiveOne(n);
    }
}