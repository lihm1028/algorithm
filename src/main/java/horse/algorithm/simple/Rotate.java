package horse.algorithm.simple;

import java.util.Arrays;
import java.util.Objects;

/**
 * 旋转数组
 * 将数组向右旋转k个位置
 * <p>
 * 如：1,2,3,4,5,6,7, k=3 时
 * 5,6,7,1,2,3,4
 *
 * @author li.hongming
 * @date 2023/2/27
 */
public class Rotate {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(nums));
        int[] rotate = rotate(nums, 3);
//        Arrays.stream(rotate).forEach(System.out::print);
        System.out.println(Arrays.toString(rotate));

    }


    public static int[] rotate(int[] nums, int k) {
        while (k > 0) {

            int last = nums[nums.length - 1];
            int i = nums.length - 1;
            while (i >= 0) {
                if (i > 0) {
                    nums[i] = nums[i - 1];
                } else {
                    nums[0] = last;
                }
                i--;
            }
            k--;
        }
        return nums;
    }
}
