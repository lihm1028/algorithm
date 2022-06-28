package horse.algorithm.string;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ShortPathSolution {


    public static void main(String[] args) {

        String longPath = "/a/b/../c/./d/../";
        System.out.println(shortPath(longPath));
    }

    public static String shortPath(String longPath) {
        List<String> list = Arrays.stream(longPath.split("/")).collect(Collectors.toList());

        System.out.println(list);

        LinkedList<String> linkedList = new LinkedList<>();
        for (String path : list) {
            if (!path.equals("")) {
                if (path.equals("..")) {
                    linkedList.pollLast();
                } else if (path.equals(".")) {

                } else {
                    linkedList.addLast("/" + path);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String path : linkedList) {
            sb.append(path);
        }
        return sb.toString();

    }

}
