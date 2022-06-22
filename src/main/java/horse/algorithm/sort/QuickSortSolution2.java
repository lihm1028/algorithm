package horse.algorithm.sort;

import java.util.Arrays;

public class QuickSortSolution2 {


    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 5, 4, 6, 1, 3};
        System.out.println(Arrays.toString(nums));
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }

    public static void quickSort(int[] nums, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = doublePointSwap(nums, startIndex, endIndex);
        quickSort(nums, startIndex, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, endIndex);
    }


    public static int doublePointSwap(int[] nums, int startIndex, int endIndex) {
        int base = nums[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left < right) {
            while (left < right && nums[right] > base) {
                right--;
            }
            while (left < right && nums[left] <= base) {
                left++;
            }
            // 没有过界则交换
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        nums[startIndex] = nums[right];
        nums[right] = base;
        return right;
    }


}

