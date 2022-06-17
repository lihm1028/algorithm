package horse.algorithm.simple;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 数组A中给定可以使用的1~9的数，返回由A数组中的元素组成的小于n（假设n为大于0的正整数）的最大数。例如A={1, 2, 4, 9}，n=2533，返回2499。
 * 例如A={1, 2, 9, 4}，n=2533，返回2499
 * <p>
 * 1.暴力递归回溯，最后判断；
 */
public class Max2 {


    public static void main(String[] args) {
        int[] A = new int[]{3, 2, 9, 4};
        System.out.println(solve(A, 2533));
//        System.out.println(solve(A, 2133));
    }

    /**
     * 1.N的前x位数字都在数组A中
     * 2.数组A中存在比N的第x+1位数字更小的数字
     */
    static String solve(int[] A, int N) {
        Arrays.sort(A);


        final Set<Integer> set = Arrays.stream(A).boxed().collect(Collectors.toSet());

        final String str = String.valueOf(N);
        final char[] nums = str.toCharArray();

        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = Arrays.binarySearch(A, nums[i] - '0');
            index = index < 0 ? -(index + 1) : index;
            if (index > 0) {
                x = i;
            }
            if (!set.contains(nums[i] - '0')) {
                break;
            }
        }

        /**
         * 知道了匹配下标数
         *
         * 前x位+小于x位的数+补位（最大）
         */
        if (x != -1) {

            int idx = Arrays.binarySearch(A, nums[x] - '0');
            idx = idx < 0 ? -(idx + 1) : idx;
            int minX = A[idx - 1];

            StringBuilder pad = new StringBuilder();
            for (int i = 0; i < str.length() - x - 1; i++) {
                pad.append(A[A.length - 1]);
            }
            return str.substring(0, x) + minX + pad.toString();
        } else {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < A.length - 1; i++) {
                sb.append(A[A.length - 1]);
            }
            return sb.toString();
        }


    }

}
