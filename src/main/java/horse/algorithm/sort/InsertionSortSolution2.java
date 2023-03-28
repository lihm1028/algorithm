package horse.algorithm.sort;

import java.util.Arrays;

public class InsertionSortSolution2 {


    public static void insertionSort(int[] nums, int n) {
        for (int i = 1; i <n ; i++) {
            int base=nums[i];
            int j=i-1;
            while (j>=0&& nums[j]>base){
                nums[j+1]=nums[j];
                j--;
            }

            nums[j+1]=base;
            System.out.println(Arrays.toString(nums)+",base="+base);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 3, 2, 1};
        System.out.println(Arrays.toString(nums));
        insertionSort(nums, nums.length);
        System.out.println(Arrays.toString(nums));
    }

}
