package horse.algorithm.sort;

import java.util.Arrays;

public class MergeSortTest {


    public static void main(String[] args) {

        int[] data = new int[]{5, 3, 6, 2, 1, 9, 4, 8, 7};
        print(data);
        mergeSort(data);
        System.out.println("排序后的数组:");
        print(data);

    }

    public static void mergeSort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    public static void sort(int[] data, int left, int right) {
        if (left >= right)
            return;
        /**
         * 找出中间索引
         */
        int center = (left + right) / 2;
        /**
         * 对左边数组进行递归
         */
        sort(data, left, center);
/**
 * 对右边数组进行递归
 */
        sort(data, center + 1, right);
        /**
         * 合并
         */
        merge(data, left, center, right);
        print(data);
    }


    public static void merge(int[] data, int left, int center, int right) {


// 临时数组
        int[] tmpArr = new int[data.length];
// 右数组第一个元素索引
        int mid = center + 1;
// third 记录临时数组的索引
        int third = left;
// 缓存左数组第一个元素的索引
        int tmp = left;
        while (left <= center && mid <= right) {
// 从两个数组中取出最小的放入临时数组
            if (data[left] <= data[mid]) {
                tmpArr[third++] = data[left++];
            } else {
                tmpArr[third++] = data[mid++];
            }

        }


        while (mid <= right) {
            tmpArr[third++] = data[mid++];
        }

        while (left <= center) {
            tmpArr[third++] = data[left++];
        }
// 将临时数组中的内容拷贝回原数组中
// (原 left-right 范围的内容被复制回原数组)

        while (tmp <= right) {
            data[tmp] = tmpArr[tmp++];
        }

    }


    public static void print(int[] data) {
        System.out.println(Arrays.toString(data));
    }
}
