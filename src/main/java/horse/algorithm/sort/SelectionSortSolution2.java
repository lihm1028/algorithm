package horse.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序：划分为已排序区间和未排序区间，将未排序区间的最小数插入到已排序去年。
 * 非稳定算法
 */
public class SelectionSortSolution2 {

    public static void main(String[] args) {

        int[] nums = new int[6];
        int n = 6;


        /**
         * 最坏的情况
         */
        nums[0] = 6;
        nums[1] = 5;
        nums[2] = 4;
        nums[3] = 3;
        nums[4] = 2;
        nums[5] = 1;

        System.out.println("排序前：" + Arrays.toString(nums));
        selectionSort(nums, n);
        System.out.println("排序后：" + Arrays.toString(nums));

    }
    
    public static void selectionSort(int[] nums, int n) {

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;

        }

    }


}
