package horse.algorithm.datastruct;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * 有界队列
 * @author li.hongming
 * @date 2023/4/7
 */
public class Queue<T> {
    //读指针
    int read;
    //写指针
    int write;
    Object[] array;
    public Queue(int initCapacity) {
        array=new Object[initCapacity];
    }

    public int getRead() {
        return read;
    }

    public int getWrite() {
        return write;
    }

    /**
     * 入列
     * @param value
     */
    public void push(T value){
        int index = (write + 1) % array.length;
        if (read == index) {
            return;
        }
        array[write]=value;
        write=index;

    }

    /**
     * 获取队列第一个元素，不出列
     * @return
     */
    public T peek(){
        if (read==write){
            return null;
        }
        return (T) array[read];
    }


    /**
     * 出列
     * @return
     */
    public T poll(){
        T temp = peek();
        if (Objects.isNull(temp)){
            return null;
        }
        read=(read+1) % array.length;
        return temp;
    }

    public int size(){
        return write>read?write-read:array.length-read+write;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(6);
        for (int i = 0; i <100; i++) {
            queue.push(i);
        }
        System.out.println(String.format("size:%s,read:%s,write:%s", queue.size(), queue.getRead(), queue.getWrite()));
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(String.format("size:%s,read:%s,write:%s", queue.size(), queue.getRead(), queue.getWrite()));

    }
}
