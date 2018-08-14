package algorithms;

public class Palindrome {
    /**
     * 在字符串中间填充特殊符号，遍历char数组的每个元素，以遍历到的元素为中心，开始遍历它左右的元素是否相等。
     * @param s
     * @return
     */
    public static int getSubPalindromeStrMaxLength(String s){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("&");//当然给定的字符串不能包含有这个特殊填充字符，否则就bug了
        for (char a: s.toCharArray()) {
            stringBuilder.append(a);
            stringBuilder.append("&");//给字符中间加塞特殊字符
        }
        int maxLen = 0;//声明回文字串最大长度
        char[] arr = stringBuilder.toString().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            maxLen = Math.max(maxLen,getLefSymmetry(arr,i));//比较取最大长度
        }

        return maxLen;
    }

    /**
     * 获取基准元素位置=i，左边n个元素和右边n个元素都相同
     * @return
     */
    public static int getLefSymmetry(char[] arr,int i){
        int len = 0;
        for (int j = 0; j <=i &&j<(arr.length-i); j++) {
            if(arr[i-j] == arr[i+j]){//若以中心点，左边距离为j，右边距离也是j都相等
                len++;//回文长度++
            }else {
                break;
            }
        }
        //原字符串的长度=(i-1)/2,左边遍历，减去一个填充就是汇文的长度
        return len-1;
    }
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(getSubPalindromeStrMaxLength(s));
    }
}
