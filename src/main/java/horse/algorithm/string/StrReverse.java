package horse.algorithm.string;

import com.sun.deploy.util.StringUtils;

/**
 * @author li.hongming
 * @date 2023/2/24
 */
public class StrReverse {

    public static void main(String[] args) {
        System.out.println(reverse(""));
        System.out.println(reverse("a"));
        System.out.println(reverse("ab"));
        System.out.println(reverse("abc"));
    }


    // 递归字符串反转
    public static String reverse(String input) {
        if (input == "" || input.length() == 1) {
            return input;
        }
        String subInput = input.substring(1);
        String subSolution = reverse(subInput);
        String solution = subSolution + input.substring(0, 1);
        return solution;
    }
}
