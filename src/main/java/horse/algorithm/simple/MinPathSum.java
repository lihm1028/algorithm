package horse.algorithm.simple;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 */
public class MinPathSum {

    public static int minPathSum(int[][] grid) {
        int width = grid[0].length, high = grid.length;
        if (high == 0 || width == 0) {
            return 0;
        }
        // 初始化
        for (int i = 1; i < high; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        printGrid(grid, "第一次处理");

        for (int i = 1; i < width; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        printGrid(grid, "第二次处理");
        for (int i = 1; i < high; i++) {
            for (int j = 1; j < width; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        printGrid(grid, "第三次处理");
        return grid[high - 1][width - 1];
    }


    private static void printGrid(int[][] grid, String title) {
        System.out.println("##########[" + title + "]################");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
                System.out.print("\t");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {

        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        printGrid(grid, "源数据");

        System.out.println(minPathSum(grid));

    }
}
