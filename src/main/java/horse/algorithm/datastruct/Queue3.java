package horse.algorithm.datastruct;

import java.util.Stack;

/**
 * 通过两个栈实现的队列
 * @author li.hongming
 * @date 2023/4/7
 */
public class Queue3<T> {

    // 用存放入列
    Stack<Object> inStack=new Stack<>();

    // 用于出列
    Stack<Object> outStack=new Stack<>();

    public void push(T value){
        inStack.push(value);
    }

    public T pop(){
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        if (outStack.isEmpty()){
            return null;
        }
        return (T)outStack.pop();
    }


    public static void main(String[] args) {

        Queue3 queue3 = new Queue3();

        queue3.push(1);
        queue3.push(2);
        System.out.println(queue3.pop());
        queue3.push(3);
        System.out.println(queue3.pop());
        System.out.println(queue3.pop());
        System.out.println(queue3.pop());
        System.out.println(queue3.pop());



    }



}
