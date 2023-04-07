package horse.algorithm.stacks.rank;

import java.util.Stack;

/**
 * @author li.hongming
 * @date 2023/4/7
 */
public class StackRank {

    /**
     * 利用一个栈将栈排序，按照栈顶从大到小。
     * @param args
     */
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(4);
        stack.push(5);
        stack.push(1);
        System.out.println("原来栈顺序："+stack);

        sortStackByStack(stack);
        System.out.println("排序后："+stack);


    }

    public static void sortStackByStack(Stack<Integer> stack){
        // 辅助栈存储栈顶从小----》大
        Stack<Integer> help = new Stack<Integer>();

        while (!stack.isEmpty()){
            Integer current = stack.pop();
            // 只要当前数比栈顶大就将辅助账中小的数出栈，并压入stack栈中
            while (!help.isEmpty() && current>help.peek()){
               stack.push(help.pop());
            }
            help.push(current);
        }

        // 将辅助栈help 填充到stack中
        while (!help.isEmpty()){
            stack.push(help.pop());
        }

    }
}
