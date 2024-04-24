import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        Map<String, String> info = new HashMap<>();
        List<String> messages = new ArrayList<>(); 

        for (String entry : record) {
            String[] parts = entry.split(" ");
            String command = parts[0];
            String userId = parts[1];
            
            if (command.equals("Enter")) {
                info.put(userId, parts[2]);
                messages.add(userId + " 들어왔습니다."); 
            } else if (command.equals("Leave")) {
                messages.add(userId + " 나갔습니다."); 
            } else { 
                info.put(userId, parts[2]); 
            }
        }

        String[] result = new String[messages.size()];
        int i = 0;
        for (String message : messages) {
            int idx = message.lastIndexOf(" ");
            String userId = message.substring(0, idx);
            String action = message.substring(idx + 1);
            result[i++] = info.get(userId) + "님이 " + action; 
        }

        return result;
    }
}