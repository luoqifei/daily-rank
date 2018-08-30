package easy;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s){
        char[] chars = s.toCharArray();
        //长度必须是偶数，否则有非法括号
        if(chars.length%2!=0){
            return false;
        }
        HashMap<Character,Character> keys = new HashMap<>();
        keys.put('{','}');
        keys.put('(',')');
        keys.put('[',']');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if(keys.containsKey(chars[i])){//如果这个字符是个左边界的括号
                //那就入栈
                stack.push(chars[i]);
            }else {//如果是右边界
                if(stack == null || stack.size() == 0){//如果开始时候输入就是'）}{'，右边界，就是非法
                    return false;
                }
                if(chars[i] == keys.get(stack.peek())){
                    stack.pop();//遇到匹配的右括号，出栈
                }else {//不匹配，那就是说明这个字符串是无效括号
                    return false;
                }
            }
        }
        if(stack.size()>0){//最后如果栈不为空，那也不是有效，比如 输入'(('
            return false;
        }else {
            return true;
        }
    }
    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(isValid(s));
    }
}
