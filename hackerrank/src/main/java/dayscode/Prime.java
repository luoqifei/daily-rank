package dayscode;

import java.util.Scanner;

/**
 * 判断是否为素数，也就是一个整数只能被1和自己整除。1不是素数
 */
public class Prime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        while (num --> 0){
            int tmp = scanner.nextInt();
            if(tmp == 1){
                System.out.println("Not Prime");
                continue;
            }
            boolean isPrime = true;
            for (int i = 2; i*i<= tmp; i++) {//O(sqrt(n)),如果是i<n,或者i<tmp/2都是o(n)复杂度
                if(tmp%i == 0) {
                    isPrime = false;
                    break;
                }else {
                    continue;
                }
            }
            System.out.println(isPrime?"Prime":"Not prime");
        }
        scanner.close();

    }
}
