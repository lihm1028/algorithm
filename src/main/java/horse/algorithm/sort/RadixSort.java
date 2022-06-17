package horse.algorithm.sort;

/**
 * 基数排序: 基数排序法是属于稳定性的排序，其时间复杂度为O (nlog(r)m)，其中r为所采取的基数，而m为堆数，在某些时候，基数排序法的效率高于其它的稳定性排序法。
 * 分配式排序：最高位优先法和最低位优先。
 * 将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。
 * 然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列。
 */
public class RadixSort {

    public static void sort(int[] number, int d) //d表示最大的数有多少位
    {

        int n = 1;
        int m = 1; //控制键值排序依据在哪一位

        /**
         * 数组的第一维表示可能的余数0-9
         */
        int[][] temp = new int[10][number.length];

        /**
         *  数组counter[i]用来表示该位是i的数的个数
         */
        int[] counter = new int[10];

        while (m <= d) {

            for (int i = 0; i < number.length; i++) {
                /**
                 * 取位上的数
                 */
                int lsd = ((number[i] / n) % 10);
                temp[lsd][counter[lsd]] = number[i];
                counter[lsd]++;
            }

            int k = 0;
            for (int i = 0; i < 10; i++) {
                /**
                 * 将当前低位排序的结果，赋值给原数组
                 */
                if (counter[i] != 0) {
                    for (int j = 0; j < counter[i]; j++) {
                        number[k] = temp[i][j];
                        k++;
                    }
                }
                counter[i] = 0;
            }
            n *= 10;
            m++;
        }
    }

    public static void main(String[] args) {
        int[] data = {73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33, 100};
        RadixSort.sort(data, 3);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
    }
}
