package algorithms;

import java.util.Scanner;

/**
 * 给一组int 类型数组，数组长度为n，求长度为n-1的子集最大和，最小和
 * 思路：
 * 先求全部和
 * 最小子集和，全部和减去最大值
 * 最大子集和，全部和减去最小值
 */
public class MiniMaxNum {
    static void miniMaxSum(int[] arr) {

        int size = arr.length;
        long sum = 0;
        for (int a: arr) {
            sum = sum+a;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 1; j < size-i; j++) {
                if(arr[j-1]>arr[j]){
                    int tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        for (int a: arr) {
            System.out.println(a);
        }
        long min = sum - arr[size-1];
        long max = sum - arr[0];
        System.out.println(min+" "+max);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
