package easy.string;

/**
 * 字符串中的单词数
 * https://leetcode-cn.com/problems/number-of-segments-in-a-string/description/
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * 示例:
 * 输入: "Hello, my name is John"
 * 输出: 5
 */
public class CountSegments {
    public static int countSegments(String s) {
        boolean isChar = false;//count++前的判断，是否之前有遇到非空字符
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isChar(s.charAt(i))) {//如果遇到非空字符
                isChar = true;//设置这个准备增加count结果的布尔值为true
            } else {
                if (isChar) {//如果是空格，并且上次有遇到N个字符
                    count++;//结果加1
                    isChar=false;//并且需要重置这个布尔值
                }
            }
        }
        if(isChar){//最后还需要判断这个布尔，避免'hello'这样的，无空格，但是最后还有一个count
            count++;
        }
        return count;
    }

    public static boolean isChar(char a) {
        if (a!=' ') {//不是空格字符
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(countSegments("Hello, my name is John"));
    }
}
