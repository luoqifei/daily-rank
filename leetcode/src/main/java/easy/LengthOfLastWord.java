package easy;

/**
 * 最后一个单词的长度
 * @see <a href="https://leetcode-cn.com/problems/length-of-last-word/description/"> leet code 最后一个单词的长度</a>
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
如果不存在最后一个单词，请返回 0 。
说明：一个单词是指由字母组成，但不包含任何空格的字符串。
示例:
输入: "Hello World"
输出: 5
 */
public class LengthOfLastWord {
    //传统方法比较笨，就是split 然后统计最后一个串的长度
    //所以，我们使用倒序遍历
    public static int lengthOfLastWord(String s) {
        int count = 0;
        if(s.trim().length() == 0){
            return count;
        }
        for (int i=s.length()-1;i>-1;i--){//倒序
            if(s.charAt(i) == ' ')continue;
            while (i>-1 && s.charAt(i)!=' '){//i 不为空
                count++;
                i--;
            }
            return count;
        }
        return count;
    }
}
