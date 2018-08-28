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

    /**
     * 返回一个字符串最长回文字串部分
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        //先填充特殊字符，让字符数组长度变成奇数
        StringBuilder sb = new StringBuilder();
        String specialChar = "%";
        sb.append(specialChar);
        for(char a : s.toCharArray()){
            sb.append(a);
            sb.append(specialChar);
        }
        //填充完成后，开始遍历字符数组每个元素，找到以该元素为中心的最大回文字串的长度，并记住索引
        char[] resultCharArr = sb.toString().toCharArray();
        int maxLength = 0;
        int pointI = 0;//记录获取较大回文串时候，基准元素的索引i
        for (int i = 0; i < resultCharArr.length; i++) {
            int tmpLength = 0;//记录以当前元素为基准的回文子串长度
            for (int j = 0; j <=i && j<resultCharArr.length-i ; j++) {//以基准为中心，步长step=1向外扩张,注意这里j必须《=i，否则长度为1的回文字符就被忽略出错
                if(resultCharArr[i-j] == resultCharArr[i+j]){//如果周边对称两点相等，回文长度加1
                    tmpLength++;
                }else {
                    break;//如果周边对称两点不相等，这以该点为基准的最长回文已获得
                }
            }
            if(tmpLength>maxLength){//如果当前基点获得了较大的子串回文
                pointI = i;
                maxLength = tmpLength-1;
            }
        }
        //遍历完成后，就获得了基准索引pointI，以及周边步长point范围内的回文，需除掉特殊字符
        StringBuilder r = new StringBuilder();
        for(int i=pointI-maxLength;i<=pointI+maxLength;i++){
            if(!String.valueOf(resultCharArr[i]).equals(specialChar)){
               r.append(resultCharArr[i]);
            }
        }
        return r.toString();
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(getSubPalindromeStrMaxLength(s));
        System.out.println(longestPalindrome(s));
    }
}
