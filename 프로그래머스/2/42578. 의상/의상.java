import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String,Integer> hm = new HashMap<>();
        
        for(String[] cloth:clothes){
            hm.put(cloth[1], hm.getOrDefault(cloth[1],0) + 1);
        }
        
        int sum = 1;
        
        for(Map.Entry<String, Integer> entry : hm.entrySet()){
            sum *= (entry.getValue() + 1);
        }
        
        return sum-1;
    }
}