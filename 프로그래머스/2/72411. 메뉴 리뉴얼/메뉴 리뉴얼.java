import java.util.*;

public class Solution {
    public String[] solution(String[] orders, int[] course) {
        Map<String, Integer> map = new HashMap<>();

        for (String order : orders) {
            char[] items = order.toCharArray();
            Arrays.sort(items); 
            
            for (int size : course) {
                combine(items, 0, new StringBuilder(), size, map);
            }
        }

        List<String> result = new ArrayList<>();
        
        for (int size : course) {
            int max = 2; 
            List<String> candidates = new ArrayList<>();
            
            for (String key : map.keySet()) {
                if (key.length() == size && map.get(key) >= max) {
                    if (map.get(key) > max) {
                        max = map.get(key);
                        candidates.clear();
                    }
                    
                    candidates.add(key);
                }
            }
            
            result.addAll(candidates);
        }

        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    private void combine(char[] items, int start, StringBuilder current, int size, Map<String, Integer> map) {
        if (current.length() == size) {
            String combination = current.toString();
            map.put(combination, map.getOrDefault(combination, 0) + 1);
            return;
        }
        for (int i = start; i < items.length; i++) {
            current.append(items[i]);
            combine(items, i + 1, current, size, map);
            current.deleteCharAt(current.length() - 1); 
        }
    }
}
