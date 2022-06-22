package horse.algorithm.sort;

import java.util.Arrays;

public class QuickSortSolution {


    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 5, 1, 3};

        System.out.println(Arrays.toString(nums));
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 入口函数（递归方法），算法的调用从这里开始。
     */
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        // 核心算法部分：分别介绍 双边指针（交换法），双边指针（挖坑法），单边指针
        int pivotIndex = doublePointerSwap(arr, startIndex, endIndex);

        // 用分界值下标区分出左右区间，进行递归调用
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }

    /**
     * 双边指针（交换法）
     * 思路：
     * 记录分界值 pivot，创建左右指针（记录下标）。
     * （分界值选择方式有：首元素，随机选取，三数取中法）
     * <p>
     * 首先从右向左找出比pivot小的数据，
     * 然后从左向右找出比pivot大的数据，
     * 左右指针数据交换，进入下次循环。
     * <p>
     * 结束循环后将当前指针数据与分界值互换，
     * 返回当前指针下标（即分界值下标）
     */
    private static int doublePointerSwap(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int leftPoint = startIndex;
        int rightPoint = endIndex;

        while (leftPoint < rightPoint) {
            // 从右向左找出比pivot小的数据
            while (leftPoint < rightPoint
                    && arr[rightPoint] > pivot) {
                rightPoint--;
            }
            // 从左向右找出比pivot大的数据
            while (leftPoint < rightPoint
                    && arr[leftPoint] <= pivot) {
                leftPoint++;
            }
            // 没有过界则交换
            if (leftPoint < rightPoint) {
                int temp = arr[leftPoint];
                arr[leftPoint] = arr[rightPoint];
                arr[rightPoint] = temp;
            }
        }
        // 最终将分界值与当前指针数据交换
        arr[startIndex] = arr[rightPoint];
        arr[rightPoint] = pivot;
        // 返回分界值所在下标
        return rightPoint;
    }


    /**
     * 双边指针（挖坑法）
     * 思路：
     * 创建左右指针。
     * 记录左指针数据为分界值 pivot，
     * 此时左指针视为"坑"，里面的数据可以被覆盖。
     * <p>
     * 首先从右向左找出比pivot小的数据，
     * 找到后立即放入左边坑中，当前位置变为新的"坑"，
     * 然后从左向右找出比pivot大的数据，
     * 找到后立即放入右边坑中，当前位置变为新的"坑"，
     * <p>
     * 结束循环后将最开始存储的分界值放入当前的"坑"中，
     * 返回当前"坑"下标（即分界值下标）
     */
    private int doublePointerHole(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int leftPoint = startIndex;
        int rightPoint = endIndex;

        while (leftPoint < rightPoint) {
            // 从右向左找出比pivot小的数据，
            while (leftPoint < rightPoint
                    && arr[rightPoint] > pivot) {
                rightPoint--;
            }
            // 找到后立即放入左边坑中，当前位置变为新的"坑"
            if (leftPoint < rightPoint) {
                arr[leftPoint] = arr[rightPoint];
                leftPoint++;
            }
            // 从左向右找出比pivot大的数据
            while (leftPoint < rightPoint
                    && arr[leftPoint] <= pivot) {
                leftPoint++;
            }
            // 找到后立即放入右边坑中，当前位置变为新的"坑"
            if (leftPoint < rightPoint) {
                arr[rightPoint] = arr[leftPoint];
                rightPoint--;
            }
        }
        // 将最开始存储的分界值放入当前的"坑"中
        arr[rightPoint] = pivot;
        return rightPoint;
    }

    /**
     * 单边指针
     * 思路：
     * 记录首元素为分界值 pivot, 创建标记 mark 指针。
     * 循环遍历与分界值对比。
     * 比分界值小，则 mark++ 后与之互换。
     * 结束循环后，将首元素分界值与当前mark互换。
     * 返回 mark 下标为分界值下标。
     */
    private int singlePointer(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int markPoint = startIndex;

        for (int i = startIndex + 1; i <= endIndex; i++) {
            // 如果比分界值小，则 mark++ 后互换。
            if (arr[i] < pivot) {
                markPoint++;
                int temp = arr[markPoint];
                arr[markPoint] = arr[i];
                arr[i] = temp;
            }
        }
        // 将首元素分界值与当前mark互换
        arr[startIndex] = arr[markPoint];
        arr[markPoint] = pivot;
        return markPoint;
    }
}
