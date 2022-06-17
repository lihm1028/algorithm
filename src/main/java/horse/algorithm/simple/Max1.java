package horse.algorithm.simple;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 数组A中给定可以使用的1~9的数，返回由A数组中的元素组成的小于n的最大数。
 * 例如A={1, 2, 9, 4}，n=2533，返回2499
 * <p>
 * 1.暴力递归回溯，最后判断；
 */
public class Max1 {


    public static void main(String[] args) {
        int[] A = new int[]{1, 2,9, 5};
        int N = 2533;
        final String solve = solve(A, N);
        System.out.println(solve);
    }

    /**
     * 1.N的前x位数字都在数组A中
     * 2.数组A中存在比N的第x+1位数字更小的数字
     */
    static String solve(int[] A, int N) {
        Arrays.sort(A);
        Set<Integer> set = Arrays.stream(A).boxed().collect(Collectors.toSet());
        int x = -1;
        String str = String.valueOf(N);
        char[] num = str.toCharArray();
        // 下标x应该尽可能大
        for (int i = 0; i < str.length(); i++) {
            // 在数组A中找到num[i]的下标
            // Char - '0'是什么意思 ASC码48就是'0'，也就是说'0'的值是48，而后依次是'1'到'9'。 这样正好是char型减去48就是它对应的int值。
            int idx = Arrays.binarySearch(A, num[i] - '0');
            idx = idx < 0 ? -(idx + 1) : idx;
            // num[i]在数组A中的下标大于0时才能更新x，因为数组A中至少需要存在1位小于当前数值的数字，这样才能满足条件2
            if (idx > 0) {
                x = i;
            }
            // 不在A数组内直接跳出循环
            if (!set.contains(num[i] - '0')) {
                break;
            }
        }
        // 找到了可行的x位置
        if (x != -1) {
            // 在数组A中找到num[i]的下标(用于获取A[idx - 1])
            int idx = Arrays.binarySearch(A, num[x] - '0');
            idx = idx < 0 ? -(idx + 1) : idx;
            // 剩余字符尽可能大
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length() - x - 1; i++) {
                sb.append(A[A.length - 1]);
            }
            // 拼接结果字符串
            return str.substring(0, x) + A[idx - 1] + sb;
        }
        // 特殊情况
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length() - 1; i++) {
                sb.append(A[A.length - 1]);
            }
            return sb.toString();
        }
    }
}
