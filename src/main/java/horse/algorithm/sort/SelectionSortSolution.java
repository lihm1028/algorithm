package horse.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序：划分为已排序区间和未排序区间，将未排序区间的最小数插入到已排序去年。
 * 非稳定算法
 */
public class SelectionSortSolution {

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
        selectionSort(nums, n);
        System.out.println("排序后：" + Arrays.toString(nums));

    }

    /**
     * 选择排序
     *
     * @param nums
     * @param n
     */
    public static void selectionSort(int[] nums, int n) {

        if (n < -1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            int minPos = i;// 记录最小的位置下标
            for (int j = i; j < n; j++) {
                /**
                 * 比较知道最小的数
                 */
                if (nums[j] < nums[minPos]) {
                    minPos = j;
                }
            }
            /**
             * 交换位置
             */
            int temp = nums[i];
            nums[i] = nums[minPos];
            nums[minPos] = temp;
        }

    }


}
