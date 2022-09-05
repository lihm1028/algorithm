package horse.algorithm.linked;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * https://www.cnblogs.com/0099-ymsml/p/15853452.html
 */
public class NodeLinkReverseOutput {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        char[] chars = line.toCharArray();
        // 获取字符数组，循环遍历放到linkedlist中，然后输出即可

        LinkedList<Character> linkedList = new LinkedList<>();

        for (char aChar : chars) {
            linkedList.add(aChar);
        }

        while (linkedList.size() > 0) {
            System.out.print(linkedList.pollLast());
        }

    }

//
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();
//        char[] chars = line.toCharArray();
//        // 获取字符数组，循环遍历放到linkedlist中，然后输出即可
//
//        LinkedList<Character> linkedList = new LinkedList<>();
//
//        for (char aChar : chars) {
//            linkedList.addFirst(aChar);
//        }
//
//        /**
//         * 输出
//         */
//        Iterator<Character> iterator = linkedList.iterator();
//        while (iterator.hasNext()) {
//            System.out.print(iterator.next());
//        }
//
//    }
}
