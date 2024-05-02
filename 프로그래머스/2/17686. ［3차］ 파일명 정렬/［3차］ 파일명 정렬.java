import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] split1 = splitFileName(o1);
                String[] split2 = splitFileName(o2);

                int headCompare = split1[0].compareToIgnoreCase(split2[0]);
                if (headCompare == 0) {
                    int num1 = Integer.parseInt(split1[1]);
                    int num2 = Integer.parseInt(split2[1]);
                    return Integer.compare(num1, num2);
                } else {
                    return headCompare;
                }
            }
        });
        return files;
    }
    
    private static String[] splitFileName(String file) {
        String head = file.split("[0-9]")[0];
        String number = file.substring(head.length()).split("[^0-9]")[0];
        return new String[] {head, number};
    }
}