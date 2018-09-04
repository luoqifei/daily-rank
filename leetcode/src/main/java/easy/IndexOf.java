package easy;

/**
 * 实现strStr() Implement strStr()
 * @see <a href="https://leetcode-cn.com/problems/implement-strstr/description/"></a>
 * 题目描述
给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串
出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
示例 1:
输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:
输入: haystack = "aaaaa", needle = "bba"
输出: -1
 */
public class IndexOf {
    public static int strStr(String haystack, String needle) {
        int size = needle.length();
        if(size == 0){
            return 0;
        }
        if(size > haystack.length()){
            return -1;
        }
        for (int i = 0; i <= haystack.length()-size; i++) {//小于等于，没必要每个母串都遍历，只需遍历到末尾长度等于needle就可以
            int j = 0;//定义j变量
            for ( j = 0; j < size; j++) {
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
            }
            if(j == size){//如果能遍历到最后，j==size
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello","ll"));
        System.out.println(strStr("aaaaa","bba"));
    }
}
