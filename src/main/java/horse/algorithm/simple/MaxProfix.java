package horse.algorithm.simple;

/**
 * 买股票最佳时机
 * @author li.hongming
 * @date 2023/2/27
 */
public class MaxProfix {
    public static void main(String[] args) {
        System.out.println(maxProfix(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfix(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfix(new int[]{6, 5, 4, 3, 2}));
    }

    public static int maxProfix(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            total += Math.max(prices[i + 1] - prices[i], 0);
        }
        return total;
    }
}
