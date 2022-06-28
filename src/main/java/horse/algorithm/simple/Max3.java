package horse.algorithm.simple;

import java.util.Arrays;

/**
 * 最近看大家面经总有一道常见的题目：
 * 数组A中给定可以使用的1~9的数，返回由A数组中的元素组成的小于n的最大数。例如A={1, 2, 4, 9}，n=2533，返回2499
 * <p>
 * 作者：Ambition
 * 链接：https://leetcode.cn/circle/discuss/BlvA0l/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * <p>
 * 2 5 3 3
 * 2499
 * <p>
 * 思路：遍历一遍数组，记录一下是否存在数字，如果当前位不存在应该找比打小一点的数，其余后面全部取最大值
 */
public class Max3 {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 9};
        System.out.println(maxNum(nums, 2533));
    }

    public static String maxNum(int[] nums, int n) {
        Arrays.sort(nums);
        char[] nchars = String.valueOf(n).toCharArray();
        boolean[] temp = new boolean[nchars.length];
        for (int i = 0; i < nchars.length; i++) {
            int index = Arrays.binarySearch(nums, nchars[i] - '0');
            temp[i] = index > -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nchars.length; i++) {
            if (temp[i]) {
                sb.append(nchars[i]);
            } else {
                int index = Arrays.binarySearch(nums, nchars[i] - '0');
                int min = nums[-(index + 1) - 1];
                sb.append(min);
                int max = nums[nums.length - 1];
                int j = i;
                while (j < nchars.length - 1) {
                    sb.append(max);
                    j++;
                }
                break;
            }
        }


        return sb.toString();

    }

}
