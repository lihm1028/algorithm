package horse.algorithm.simple;

import java.util.HashMap;
import java.util.Map;


/**
 * 假设楼梯有n个台阶，每次可以走1个台阶或者2个台阶，求有多少种走法m。
 * 输入 n=1 输出m=1
 * 输入 n=2 输出m=2
 * 输入 n=7 输出m=21
 */
public class FootstepSolution {


    private static Map<Integer, Integer> footstepMap = new HashMap<>();

    public static int footstep(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }
        if (footstepMap.containsKey(n)) {
            return footstepMap.get(n);
        }
        return footstep(n - 1) + footstep(n - 2);
    }

    private static long f(long n) {
        if (n <= 1) {
            return 1;
        }
        return n * f(n - 1);
    }


    public static void main(String[] args) {

        System.out.println(f(21));

//        int n = 7;
//        System.out.println(n + "级台阶有" + footstep(7) + "种走法");
//        System.out.println("10级台阶有" + footstep(10) + "种走法");


    }
}
