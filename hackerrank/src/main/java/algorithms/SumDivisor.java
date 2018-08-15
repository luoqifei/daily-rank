package algorithms;

/**
 * 求一个整数0~1000的所有除数的和
 * 比如6，6的被除数就是1，2，3，加上本身就是1，2，3，6，总和就是12
 */
public class SumDivisor {
    public static int getSumDivisor(int n){
        if(n == 1){
            return 1;
        }
        int sum = 1;
        for (int i = 2; i <= n/2; i++) {//i需要从2开始，因为sum初始值等于1，而且i不能大于n的一半。
            if(n%i == 0){
                System.out.println(i+" is one  divisor of "+n);
                sum = sum+i;//将所有除数加和，不包含n本身
            }
        }
        return  sum + n;
    }
    public static void main(String[] args) {
        int n = 6;
        System.out.println(getSumDivisor(n));
    }
}
