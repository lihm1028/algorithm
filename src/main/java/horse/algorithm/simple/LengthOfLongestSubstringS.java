package horse.algorithm.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串s ，请你找出其中不含有重复字符的 最长子串的长度。
 */
public class LengthOfLongestSubstringS {


    /**
     * s = "abcabcd23abc"
     * <p>
     * abcabcd23abc
     * <p>
     * abc       max=2-0+1 ,  flag=0
     * abca      max=3，3-0 ,flag=1
     * abcab     4-3 , max=3,flag=2
     * abcabc    5-2, max=3 ,flag=3
     * abcabcd   6-flag=4 ,max=4,flag=3
     * abcabcd2  7-flag=5,max=5
     * abcabcd23 8-flag=6, max=6
     * abcabcd23a 9-3=6,flag= max=6, flag=4
     * abcabcd23ab 10-4=6, max=6 ,flag=5
     * abcabcd23abcx 11-5=6, max=6,flag=6
     *
     * @param str
     * @return
     */
    public static int lengthOfLongestSubstring(String str) {

        if (str.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;//标记left指针
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                 Integer index = map.get(str.charAt(i));
                int len = index < left ? i - left + 1 : i - index;
                max = Math.max(max, len);
                map.put(str.charAt(i), i);
                left = Math.max(left, index + 1);
                if (i > 1 && str.charAt(i) == str.charAt(i - 1)) {
                    left = i;
                }

            } else {
                max = Math.max(max, i - left + 1);
                map.put(str.charAt(i), i);
            }
        }
        return max;
    }


    public static void main(String[] args) {
//        String str = "abc";
//        String str = "abcabcd23abc";
//        String str = "pwwwkew";
//        String str = "aab";
//        String str = "abba";
        String str = "ckilbkd";
//        String str = "aabaab!bb";
        System.out.println(lengthOfLongestSubstring(str));

    }
}
