package horse.algorithm.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
 */
public class TwoSumTest {


    public static void main(String[] args) {
//
        int[] nums = new int[]{2, 11, 7, 15};
        int target = 9;
//        int[] nums = new int[]{2, 7, 11, 15, 5, 5, 3, 3};
//        int target = 10;

//        System.out.println(Arrays.toString(twoSum1(nums, target)));
//        System.out.println(Arrays.toString(twoSum2(nums, target)));
        System.out.println(Arrays.toString(twoSum3(nums, target)));

    }


    /**
     * 两次循环遍历
     *
     * @param nums
     * @param target
     * @return
     */
    static int[] twoSum1(int[] nums, int target) {

        /**
         * 两次循环遍历
         */
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[2];
    }


    /**
     * @param nums
     * @param target
     * @return
     */
    static int[] twoSum2(int[] nums, int target) {

        /**
         *
         * 空间换时间
         * 将数组转换到哈希表，利用哈希表查找元素时间复杂度O(1)
         *
         */
        Map<Integer, Integer> maps = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            maps.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int dif = target - nums[i];
            /**
             * 直接通过key查找，这里需要排除自己
             */
            if (maps.containsKey(dif) && maps.get(dif) != i) {
                return new int[]{i, maps.get(dif)};
            }
        }
        return new int[2];
    }


    static int[] twoSum3(int[] nums, int target) {
        int[] indexs = new int[2];
        /**
         *  建立k-v ，一一对应的哈希表
         *  循环1次，将差作为key，value 当前索引
         */
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target - nums[i], i);
        }
        return indexs;
    }


}
