import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int mapSize = 26;

        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(String.valueOf(c), c - 'A' + 1);
        }

        int i = 0;
        while (i < msg.length()) {
            String current = null;
            int j = 1;
            while (i + j <= msg.length()) {
                String test = msg.substring(i, i + j);
                if (map.containsKey(test)) {
                    current = test;
                    j++;
                } else {
                    map.put(test, ++mapSize);  
                    break;
                }
            }

            list.add(map.get(current));
            i += current.length();  
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

