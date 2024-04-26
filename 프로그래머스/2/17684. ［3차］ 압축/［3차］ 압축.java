import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int mapSize = 26;

        for (char c = 'A'; c <= 'Z'; c++) {
            map.put(String.valueOf(c), c - 'A' + 1);
        }

       
        for(int i=0;i<msg.length();){
            String current = null;
            for(int j=1;j<=msg.length()-i;j++){
                String test = msg.substring(i, i + j);
                
                if (!map.containsKey(test)) {
                    map.put(test, ++mapSize);  
                    break;
                } 
                current=test;
            }

            list.add(map.get(current));
            i += current.length();  
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

