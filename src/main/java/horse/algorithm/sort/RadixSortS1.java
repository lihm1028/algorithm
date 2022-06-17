package horse.algorithm.sort;

import java.util.Arrays;

/**
 * 基数排序: 基数排序法是属于稳定性的排序，其时间复杂度为O (nlog(r)m)，其中r为所采取的基数，而m为堆数，在某些时候，基数排序法的效率高于其它的稳定性排序法。
 * 分配式排序：最高位优先法和最低位优先。
 * 将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。
 * 然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
 *
 *
 * <p>
 * 将大写字母排在后面，小写字母排在前面。不要求顺序
 */
public class RadixSortS1 {


    public static void main(String[] args) {
        char[] str = {'D', 'a', 'F', 'B', 'c', 'A', 'Z' };

        System.out.println("排序前：" + Arrays.toString(str));
        reorg(str, str.length);
        System.out.println("排序后：" + Arrays.toString(str));

    }

    public static void reorg(char[] str, int n) {


        int i = 0;
        int j = n - 1;

        while (true) {

            /**
             * 如果是小写字母就移动i，找到非小写字母停下
             */
            while (i < j && str[i] >= 'a' && str[i] <= 'z') {
                ++i;
            }

            /**
             * 如果是大写字母就向左移动j,找到非大写字母就停下
             */
            while (i < j && str[j] >= 'A' && str[j] <= 'Z') {
                --j;
            }

            if (i >= j) {
                break;
            }
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;

        }


    }


}
