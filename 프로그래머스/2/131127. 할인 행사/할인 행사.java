import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int result = 0;
        int duration = 10;
        
        Map<String, Integer> requiredItems = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            requiredItems.put(want[i], number[i]);
        }
        
        for (int start = 0; start <= discount.length - duration; start++) {
            Map<String, Integer> currentWindow = new HashMap<>();
            
            for (int j = 0; j < duration; j++) {
                String item = discount[start + j];
                currentWindow.put(item, currentWindow.getOrDefault(item, 0) + 1);
            }
            
            boolean matches = true;
            for (String key : requiredItems.keySet()) {
                if (!requiredItems.get(key).equals(currentWindow.get(key))) {
                    matches = false;
                    break;
                }
            }
            
            if (matches) {
                result++;
            }
        }
        
        return result;
    }
}
