package easy.string;

/**
 * 验证回文串
 * 回文：正读和反读都是一样的字符串
 * https://leetcode-cn.com/problems/valid-palindrome/description/
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */
public class IsPalindrome {
    //首先忽略大小写，以及只考虑字母和数字，也就是要跳过特殊字符
    public static boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();//先集体变小写
        int leftIndex = 0;//左指针
        int rightIndex = s.length() - 1;//右指针
        while (leftIndex < rightIndex) {
            while (!isValidChar(s.charAt(leftIndex)) && leftIndex<rightIndex) {//循环，直到找到合法的字符
                leftIndex++;
            }
            while (!isValidChar(s.charAt(rightIndex)) && leftIndex<rightIndex) {//循环，且保证不比左指针小，否则越界
                rightIndex--;
            }
            //此时，两个指针可能指向同一个字符，或者指向两个位置的有效字符
            if (!String.valueOf(s.charAt(leftIndex)).equals(//如果发现首尾对称位置的字符不相等就不是回文
                    String.valueOf(s.charAt(rightIndex)))) {
                return false;
            }
            leftIndex++;//比较完后，继续移动
            rightIndex--;
        }
        return true;
    }

    //a must be lower
    public static boolean isValidChar(char a) {
        if (a >= 'a' && a <= 'z' || a >= '0' && a <= '9') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(".,"));
    }
}
