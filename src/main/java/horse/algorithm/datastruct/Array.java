package horse.algorithm.datastruct;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * 动态数组
 * put get
 * size
 *
 * @author li.hongming
 * @date 2023/4/7
 */
public class Array<T> {

    static final int DEFAULT_CAPACITY = 10;
    int size;
    Object[] array;

    public Array() {
        this(DEFAULT_CAPACITY);
        ;
    }

    public Array(int initCapacity) {
        array = new Object[initCapacity];
    }

    void put(T value) {
        Objects.requireNonNull(value);
         if (size>= array.length){
            array= Arrays.copyOf(array,array.length<<1);
         }
         array[size++]=value;
    }

    T get(int index) {
        if (index<0 || index>size){
            return null;
        }

        return (T) array[index];
    }

    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 20; i++) {
            array.put(i);
        }
        Stream.of(array.array).forEach(x->System.out.println(x));
    }

}
