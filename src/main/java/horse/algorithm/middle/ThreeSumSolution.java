package horse.algorithm.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-medium/xvpj16/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ThreeSumSolution {

    public static List<List<Integer>> threeSum(int[] nums) {
        /**
         * 存放符合条件的集合
         */
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            /**
             * 排过序的，如果原始大于0，后面都大于0不符合了，终止退出
             */
            if (nums[i] > 0) {
                break;
            }
            /**
             * 重复数据只要算1次就可以了
             */
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if ((nums[i] + nums[left] + nums[right]) > 0) {
                    right--;
                } else if ((nums[i] + nums[left] + nums[right]) < 0) {
                    left++;
                } else {
                    List<Integer> match = new ArrayList<>();
                    match.add(nums[i]);
                    match.add(nums[left]);
                    match.add(nums[right]);
                    res.add(match);
                    //要继续走下去，可能还有
                    right--;
                    left++;

                    // 重复的不要走了
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right + 1] == nums[right]) {
                        right--;
                    }
                }


            }

        }


        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        final List<List<Integer>> threeSum = threeSum(nums);
        System.out.println(threeSum);
    }
}
