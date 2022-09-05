package horse.algorithm.string;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ShortPathSolution {


    public static void main(String[] args) {

        String longPath = "/a/b/../c/./d/../";
        System.out.println(shortPath(longPath));
    }


    private static String shortPath(String longPath) {

        String[] split = longPath.split("/");
        List<String> paths = Arrays.stream(split)
                .collect(Collectors.toList());
        LinkedList<String> dirs = new LinkedList<>();
        for (String path : paths) {
            if (!path.equals("")) {
                if (path.equals("..")) {
                    dirs.pollLast();
                } else if (path.equals(".")) {

                } else {
                    dirs.addLast("/" + path);
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        Iterator<String> iterator = dirs.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
        }

//        dirs.forEach(item -> {
//            sb.append(item);
//        });

        return sb.toString();

    }

//    public static String shortPath(String longPath) {
//        List<String> list = Arrays.stream(longPath.split("/")).collect(Collectors.toList());
//
//        System.out.println(list);
//
//        LinkedList<String> linkedList = new LinkedList<>();
//        for (String path : list) {
//            if (!path.equals("")) {
//                if (path.equals("..")) {
//                    linkedList.pollLast();
//                } else if (path.equals(".")) {
//
//                } else {
//                    linkedList.addLast("/" + path);
//                }
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        for (String path : linkedList) {
//            sb.append(path);
//        }
//        return sb.toString();
//    }

}
