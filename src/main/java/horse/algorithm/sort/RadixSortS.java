package horse.algorithm.sort;

import java.util.Arrays;

/**
 * 基数排序: 基数排序属于稳定性排序，和桶排序、计数排序类似，是一种分配式排序方法，通过最高位优先法和最低位优先法。
 * 时间复杂度是线性对数阶，主要受到采用的基数和元素数量有关。
 * 核心思想：将待排序的数，统一为同样数位长度，数位较短的数前面补零，然后从最低位开始排序，从最低位到最高位排序完成后，就形成了有序序列。
 */
public class RadixSortS {


    private static void sort(int[] numbers, int d) {

        /**
         * 定义一个临时数组，用于存放排序结果
         */
        int[][] temp = new int[10][numbers.length];

        /**
         * 存放基数对应的元素数量
         */
        int[] counter = new int[10];

        int m = 1;
        int n = 1;
        while (m <= d) {

            /**
             * 按照基数0-9分组，存放到temp，并记录对应数量counter
             */
            for (int i = 0; i < numbers.length; i++) {
                int lsd = (numbers[i] / n) % 10;
                temp[lsd][counter[lsd]] = numbers[i];
                counter[lsd]++;
            }


            /**
             * 将第一次排序的结果赋值给原数组
             */
            int k = 0;
            for (int i = 0; i < counter.length; i++) {
                for (int c = 0; c < counter[i]; c++) {
                    numbers[k] = temp[i][c];
                    k++;
                }
                counter[i] = 0;
            }
            System.out.println("按照第" + m + "位排序后：" + Arrays.toString(numbers));

            n = n * 10;
            m++;
        }


    }

    public static void main(String[] args) {
        int[] nums = {22, 3, 13, 41, 26, 54, 66, 111, 200, 100, 10, 1, 75, 87};
        System.out.println("排序前：" + Arrays.toString(nums));
        sort(nums, 3);
        System.out.println("排序后：" + Arrays.toString(nums));
    }

}
