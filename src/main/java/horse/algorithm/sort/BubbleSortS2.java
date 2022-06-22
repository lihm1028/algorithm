package horse.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序--属于原地排序法
 * 平均时间复杂度 O(n²)
 * 空间复杂度 O(1)--需要申请一个临时变量
 * <p>
 * 次数固定，每次都把最大的冒泡到最后。
 */
public class BubbleSortS2 {

    public static void bubbleSort(int[] nums, int n) {
        for (int i = 0; i < n - 1; i++) {

            boolean flag = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                return;
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = new int[6];
        int n = 6;


//        /**
//         * 最坏的情况
//         */
        nums[0] = 6;
        nums[1] = 5;
        nums[2] = 4;
        nums[3] = 3;
        nums[4] = 2;
        nums[5] = 1;

        System.out.println("排序前：" + Arrays.toString(nums));
        bubbleSort(nums, n);
        System.out.println("排序后：" + Arrays.toString(nums));

    }
}
