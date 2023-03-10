package horse.algorithm.simple;

import java.util.Arrays;

/**
 * @author li.hongming
 * @date 2023/3/8
 */
public class ContainDuplicateDemo {

    // 判断数组是否存在重复元素
    public static void main(String[] args) {
        System.out.println(containDuplicate(new int[]{1, 2, 3, 2, 1}));
        System.out.println(containDuplicate(new int[]{1, 2, 3, 4, 5}));
    }

    public static boolean containDuplicate(int[] nums) {
        // 利用java工具类排序--双轴驱快速排序
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
