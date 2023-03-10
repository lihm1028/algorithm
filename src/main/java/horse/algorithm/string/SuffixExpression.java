package horse.algorithm.string;

import com.google.common.collect.Lists;
import com.sun.tools.javac.util.StringUtils;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author li.hongming
 * @date 2023/3/10
 */
public class SuffixExpression {
    /**
     *  中缀表达式转换后缀表达式 规则：
     *  1.根据计算顺序，对上面的式子逐层加括号。
     *  2.将每层括号内的符号移到对应外层外。
     */

    //中缀表达式转换后缀表达式
    //(a+b)*c-d
    //-->(((a+b)*c)-d) --> ab+c*d-


    /**
     * 后缀表达式转换中缀表达式 规则：
     * 1.对标中缀转后缀，也就是把符号提到括号前面即可。
     */
    // 后缀转换中缀表达式 ab+c*d-
    // (((a+b)*c)-d)-->(a+b)*c-d
    public static void main(String[] args) {
        System.out.println(suffixExp(new String[]{"1", "2", "+", "3" , "*", "4", "-"}));
    }

    public static int suffixExp(String[] exps) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < exps.length; i++) {
            if (!isOperation(exps[i])) {
                stack.push(Integer.parseInt(exps[i]));

            } else {
                Integer right = stack.pop();
                Integer left = stack.pop();

                switch (exps[i]) {
                    case "+":
                        stack.push(left + right);
                        break;
                    case "-":
                        stack.push(left - right);
                        break;
                    case "*":
                        stack.push(left * right);
                        break;
                    case "/":
                        stack.push(left / right);
                        break;
                }

            }
        }
        return stack.pop();
    }

    public static boolean isOperation(String input) {
        if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/")) {
            return true;
        }
        return false;
    }

}
