package easy.string;

/**
 * 反转字符串
 * https://leetcode-cn.com/problems/reverse-string/description/
 * 编写一个函数，其作用是将输入的字符串反转过来。
 * 示例 1:
 * 输入: "hello"
 * 输出: "olleh"
 * 示例 2:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: "amanaP :lanac a ,nalp a ,nam A"
 */
public class ReverseString {
    public static String reverseString(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
    }
}
