package horse.algorithm.sort;

import java.util.Arrays;

public class InsertionSortSolution2 {


    /**
     * 十大经典排序算法
     * https://blog.csdn.net/weixin_44478077/article/details/116376518
     *
     *  冒泡排序
     *  快速排序
     *  选择排序
     *  插入排序
     *  希尔排序
     *  归并排序
     *  堆排序
     *  基数排序
     *  桶排序
     *
     * @param nums
     * @param n
     */
    public static void insertionSort(int[] nums, int n) {

        for (int i=1;i<n;i++){
            int base=nums[i];
            int j=i-1;
            while (j>=0 && nums[j]>base){
                nums[j+1]=nums[j];
                j--;
            }
            nums[j+1]=base;
            System.out.println(Arrays.toString(nums));
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 3, 2, 1};
        System.out.println(Arrays.toString(nums));
        insertionSort(nums, nums.length);
        System.out.println(Arrays.toString(nums));
    }

}
