package horse.algorithm.sort;

import java.util.Arrays;

/**
 * 基数排序:
 * <p>
 * 将大写字母排在后面，小写字母排在前面,数字排在中间。不要求顺序
 */
public class RadixSortS2 {


    public static void main(String[] args) {
        char[] str = {'D', 'a', 'F', 'B', '3', 'c', 'A', 'b', 'x', 'Z', '4' };

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
            while (i < j && (str[i] < 'A' || str[i] > 'Z')) {
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

        j = i - 1;
        i = 0;
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
            while (i < j && str[j] >= '0' && str[j] <= '9') {
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
