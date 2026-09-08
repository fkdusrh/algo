import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String result = null;
        HashMap<String,Integer> map = new HashMap<>();
        
        for(String completeUser:completion){
            map.put(completeUser, map.getOrDefault(completeUser,0)+1);
        }
        
        for(String user:participant){
            if(map.getOrDefault(user, 0)<1){
                result = user;
                break;
            }
            map.put(user, map.getOrDefault(user,0)-1);
        }
        
        return result;
    }
}