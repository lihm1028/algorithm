package horse.algorithm.string;

/**
 * @author li.hongming
 * @date 2023/2/25
 */
public class StringDemo {
    public static void main(String[] args) {

        java.lang.String s = "a";
        System.out.println(s.hashCode());
        s = "ab";
        System.out.println(s.hashCode());

        StringBuffer sb = new StringBuffer("a");
        System.out.println(sb.hashCode());
        sb.append("b");
        System.out.println(sb.hashCode());
    }
}
