package dayscode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 给一个Given a  6*6 2D Array，求漏斗型子集最大和
 * @Link https://www.hackerrank.com/challenges/30-2d-arrays/problem
 */
public class TwoDArray {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        List<Integer> sumList = new ArrayList();
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                int tmpSum = arr[i][j]+arr[i][j+1]+arr[i][j+2]
                        +arr[i+1][j+1]
                        +arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
                sumList.add(tmpSum);
            }
        }
        int maxSum = sumList.get(0);
        for(int i=0; i<sumList.size(); i++){
            if(sumList.get(i)>maxSum){
                maxSum = sumList.get(i);
            }
        }
        System.out.println(maxSum);
        scanner.close();
    }

}