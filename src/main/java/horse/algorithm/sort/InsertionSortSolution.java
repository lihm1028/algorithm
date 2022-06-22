package horse.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序：将未排序的元素插入到已排序区间，比冒泡排序性能好（冒泡有交换 3句赋值，插入只有一次赋值。）。
 * <p>
 * <p>
 * 4,5,6,3,2,1
 * <p>
 * <p>
 * <p>
 * <p>
 * 6,5,4,3,2,1
 * <p>
 * 需要6次循环
 * 5,6,4,3,2,1
 * <p>
 * 5,6,4,3,2,1
 * <p>
 * 4,5,6,3,2,1
 * <p>
 * 3,4,5,6,2,1
 * <p>
 * 2,3,4,5,6,1
 * <p>
 * 1,2,3,4,5,6
 */
public class InsertionSortSolution {

    public static void main(String[] args) {

        int[] nums = new int[6];
        int n = 6;


        nums[0] = 4;
        nums[1] = 5;
        nums[2] = 6;
        nums[3] = 3;
        nums[3] = 2;
        nums[4] = 2;
        nums[5] = 1;


        /**
         * 最坏的情况
         */
//        nums[0] = 6;
//        nums[1] = 5;
//        nums[2] = 4;
//        nums[3] = 3;
//        nums[4] = 2;
//        nums[5] = 1;

        System.out.println("排序前：" + Arrays.toString(nums));
        insertionSort2(nums, n);

        System.out.println("排序后：" + Arrays.toString(nums));

    }

    public static void insertionSort(int[] nums, int n) {

        for (int i = 1; i < n; i++) {
            int temp = nums[i];
            for (int j = i - 1; j >= 0; --j) {
                if (nums[j] > temp) {
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }

        }

    }


    /**
     * 插入排序，就是将当前key和签名
     *
     * @param nums
     * @param n
     */
    public static void insertionSort2(int[] nums, int n) {

        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;
            /**
             * 将待插入原始和它前面元素比较，如果前面元素大于当前元素 就进行位置搬移
             */
            while (j >= 0 && nums[j] > key) {
                /**
                 * 将待插入原始和它前面元素比较，如果前面元素大于当前元素 就进行位置搬移
                 */
                nums[j + 1] = nums[j];
                j--;
            }
            /**
             *
             */
            nums[j + 1] = key;
            System.out.println("排序：" + Arrays.toString(nums));

        }

    }
}
