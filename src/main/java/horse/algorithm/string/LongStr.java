package horse.algorithm.string;

/**
 * @author li.hongming
 * @date 2023/2/9
 */
public class LongStr {
    public static void main(String[] args) {
        String source = "ab123cab123d";
//        String source = "bbbbbb";
        System.out.println(extracted(source));


    }

    private static String extracted(String source) {

        int start = 0;
        if (source.length() == 1) {
            return source;
        }
        String longstr = source.substring(0,1);
        for (int i = start+1; i < source.length(); i++) {
            if (source.substring(start, i).indexOf(source.charAt(i)) < 0) {
                if (source.substring(start, i+1).length()>longstr.length()){
                    longstr=source.substring(start, i+1);
                }
            } else {
                start = start + 1;
            }
        }

        return longstr;
    }
}
