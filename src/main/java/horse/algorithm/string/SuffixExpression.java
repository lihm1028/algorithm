package horse.algorithm.string;

/**
 * @author li.hongming
 * @date 2023/3/10
 */
public class SuffixExpression {
    /**
     *  中缀表达式转换后缀表达式 规则：
     *  1.根据计算顺序，对上面的式子逐层加括号。
     *  2.将每层括号内的符号移到对应外层外。
     */

    //中缀表达式转换后缀表达式
    //(a+b)*c-d
    //-->(((a+b)*c)-d) --> ab+c*d-


    /**
     *  后缀表达式转换中缀表达式 规则：
     *  1.对标中缀转后缀，也就是把符号提到括号前面即可。
     */
    // 后缀转换中缀表达式 ab+c*d-
    // (((a+b)*c)-d)-->(a+b)*c-d


}
