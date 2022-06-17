package horse.algorithm.simple;

import java.util.Arrays;

/**
 * java 二分查找（折半查找）
 */
public class ArraysbinarySearch {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 10};

        /**
         * 对于查找到时，返回的是对应的下标。
         */
        System.out.println(Arrays.binarySearch(nums, 3));
        System.out.println(Arrays.binarySearch(nums, 5));
        System.out.println(Arrays.binarySearch(nums, 7));
        System.out.println(Arrays.binarySearch(nums, 11));
        System.out.println(Arrays.binarySearch(nums, 120));




    }


}
