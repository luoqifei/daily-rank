package algorithms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 给一组int 类型数组，数组长度为n，求长度为n-1的子集最大和，最小和
 * 思路：
 * 先求全部和
 * 最小子集和，全部和减去最大值
 * 最大子集和，全部和减去最小值
 */
public class MiniMaxNum {
    private static final Scanner scanner = new Scanner(System.in);

        static int birthdayCakeCandles(int[] ar) {
            int max = ar[0];
            for(int i = 0;i<ar.length;i++){
                if(ar[i]>=max){
                    max = ar[i];
                }
            }
            int blowout = 0;
            for (int i = 0;i<ar.length;i++) {
                if(ar[i]==max){
                    blowout++;
                }
            }
            return blowout;
        }



    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/qifei/txt"));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = birthdayCakeCandles(ar);
        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
