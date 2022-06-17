package horse.algorithm.simple;

/**
 * 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions/xmlwi1/
 */
public class SearchMatrixQ {

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
        System.out.println(searchMatrix(matrix, target));
        System.out.println(searchMatrix(matrix, 19));

    }


    static boolean searchMatrix(int[][] matrix, int target) {
        /**
         * 每行的元素从左到右升序排列。
         * 每列的元素从上到下升序排列。
         * 可以把[j][0]看做根节点，只要目标值大于节点就将i向右移动，否则就将j向下移动
         */
        final int col = matrix[0].length;
        final int row = matrix.length;
        int i = 0;
        int j = row - 1;
        boolean find = false;
        int count = 0;
        while (i < col && j >= 0) {

            count++;
            if (target > matrix[j][i]) {
                i++;
            } else if (target < matrix[j][i]) {
                j--;
            } else {
                find = true;
                break;
            }
        }
        System.out.println("查找用了" + count + "次。");
        return find;
    }
}
