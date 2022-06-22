package horse.algorithm.middle;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 动态规划
 */
public class MaxSubArraySolution {


    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

    public static int maxSubArray(int[] nums) {
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
        int res = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            System.out.println(i + "：" + Arrays.toString(dp));
//            if (dp[i - 1] > 0) {
//                dp[i] = dp[i - 1] + nums[i];
//            } else {
//                dp[i] = nums[i];
//            }
//            if (dp[i] > res) {
//                res = dp[i];
//            }
//
//            System.out.println(i + "：" + Arrays.toString(dp));
//        }
        return res;

    }

    public static int maxSubArray2(int[] nums) {
        /**
         * 申请一个变量，存放当前最大值
         */
        int maxSum = 0;
        /**
         * 临时数组，记录上一区间原始最大值
         */
        int[] temp = new int[nums.length];
        temp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            /**
             * 递推算出上一个连续数相加的和
             */
            if (temp[i - 1] > 0) {
                temp[i] = temp[i - 1] + nums[i];
            } else {
                temp[i] = nums[i];
            }
            /**
             * 将最大值保存起来
             */
            if (temp[i] > maxSum) {
                maxSum = temp[i];
            }
        }


        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        System.out.println(Arrays.toString(nums));
//        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray2(nums));
    }

}
