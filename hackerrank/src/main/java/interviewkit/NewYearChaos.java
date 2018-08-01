package interviewkit;

import java.util.Scanner;

/**
 * 每个人身上有一个序号，后面的人可以和紧挨着前面的那个人换位，但每个人最多换位两次。
 * 队列 1 2 3 4 5
 *
 * @Link https://www.hackerrank.com/challenges/new-year-chaos
 */
public class NewYearChaos {
    static void minimumBribes(int[] q) {
        int bribe = 0;
        boolean chaotic = false;
        for(int i = 0; i < q.length; i++)
        {
            if(q[i]-(i+1) > 2)//如果挨着的两个人，前面的比后面的那个大超过2，就是有人违规，太乱了
            {
                chaotic = true;
                break;
            }
            for (int j = Math.max(0, q[i]-2); j < i; j++) {
                if (q[j] > q[i]) bribe++;
            }
        }
        if(chaotic) System.out.println("Too chaotic");
        else System.out.println(bribe);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
