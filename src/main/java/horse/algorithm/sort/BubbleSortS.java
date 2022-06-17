package horse.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序--属于原地排序法
 * 平均时间复杂度 O(n²)
 * 空间复杂度 O(1)--需要申请一个临时变量
 *
 * 次数固定，每次都把最大的冒泡到最后。
 */
public class BubbleSortS {

    public static void bubbleSort(int[] nums, int n) {
        /**
         *  表示趟数，一共 length-1 次
         */
        for (int i = 0; i < n - 1; i++) {
            /**
             * 是否交换标识，终止多余次数
             *
             */
            boolean flag = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = true;
                }
            }

            System.out.println("交换了多少轮：" + (i + 1));
            /**
             * 这一轮没有发生交换，说明数据的顺序已经排好，没有必要继续进行下去。
             */
            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = new int[6];
        int n = 6;


        nums[0] = 4;
        nums[1] = 5;
        nums[2] = 6;
        nums[3] = 3;
        nums[4] = 2;
        nums[5] = 1;


//        /**
//         * 最坏的情况
//         */
//        nums[0] = 6;
//        nums[1] = 5;
//        nums[2] = 4;
//        nums[3] = 3;
//        nums[4] = 2;
//        nums[5] = 1;

        System.out.println("排序前：" + Arrays.toString(nums));
        bubbleSort(nums, n);

        System.out.println("排序后：" + Arrays.toString(nums));


    }
}
