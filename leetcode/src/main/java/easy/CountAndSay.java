package easy;

/**
 * 报数
 * 报数序列是指一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是1，第二项是11，第五项是111221，很明显，第六项就是312211，现在就是求第n项内容是多少。
 * @see <a href="https://leetcode-cn.com/problems/count-and-say/description/">leetcode 报数</a>
 */
public class CountAndSay {
    public static String countAndSay(int n) {
        String source = "1";
        for (int i = 1; i < n; i++) {//第n项，就是报数n-1次
            source = convert(source);
        }
        return source;
    }

    public static String convert(String str) {
        char[] chars = str.toCharArray();
        int charCount = 1;//字符数量默认至少为1
        char charSymbol = chars[0];//第一个字符
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {//i必须以1开始，因为charSymbol已经定位是第一个了，而且方便下一句code
            if (chars[i] == chars[i - 1]) {//如果i从0开始，这里的判断条件就是i<chars.length-1,而且是char[i] == char [i+1]费劲
                charCount++;//如果遍历的这个元素和charSymbol相同，就增加这个字符的统计量-报数
            } else {
                resultBuilder.append(charCount + "" + charSymbol);//记录存入结果集，n个charSymbol
                //开始下一个字符的报数统计
                charSymbol = chars[i];//更新目标charSymbol为当前的字符
                charCount = 1;//重置字符 count统计为1
            }
        }
        resultBuilder.append(charCount+""+charSymbol);//将最后的一个统计也加入到结果
        return resultBuilder.toString();
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("n="+n+", result = "+countAndSay(n));
    }
}
