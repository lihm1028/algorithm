package horse.algorithm.datastruct;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过集合实现队列
 * @author li.hongming
 * @date 2023/4/7
 */
public class Queue2<T> {
   List<Object> list= new ArrayList<>();
   // 下标
   int index;

   public void push(T value){
       list.add(value);
       index++;
   }

   public T poll(){
        if (!list.isEmpty()){
            index--;
           return (T)list.remove(0);
        }
        return null;
   }

   public int size(){
       return list.size();
   }

    public static void main(String[] args) {


        Queue2<Integer> queue2 = new Queue2<>();
        for (int i = 0; i < 20; i++) {
            queue2.push(i);
        }
        System.out.println("size="+queue2.size());

        for (int i = 0; i <5; i++) {
            System.out.println(queue2.poll());
            System.out.println("size="+queue2.size());
        }
        System.out.println("size="+queue2.size());

    }
}
