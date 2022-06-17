package horse.algorithm.simple;

/**
 * 设计一个算法，算出 n 阶乘有多少个尾随零。
 */
public class TrailingZeroesSolution {

    public static void main(String[] args) {

        System.out.println(waythree(10));
        System.out.println(trailingZeroes(10));

    }

    public static int trailingZeroes(int n) {

        int count = 0;
        while (n >= 5) {
            n = n / 5;
            count = count + n;
        }
        return count;
    }


    /**
     * 数组添加计算阶乘
     *
     * @param num
     * @return
     */
    public static long waythree(int num) {
        long[] arr = new long[21];
        arr[0] = 1;
        int last = 0;
        if (num >= arr.length) {
            throw new IllegalArgumentException("传入的值太大了！");//抛出不合理参数异常
        }
        if (num < 0) {
            throw new IllegalArgumentException("需要计算的参数必须为正数！");//抛出不合理参数异常
        }
        while (last < num) {
            arr[last + 1] = arr[last] * (last + 1);
            last++;
        }
        return arr[num];
    }

}
