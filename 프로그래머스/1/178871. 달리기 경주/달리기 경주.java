import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] ranking = new String[players.length];
        Map<String, Integer> hm = new HashMap<>();
        
        for(int i=0;i<players.length;i++){
            String player = players[i];
            
            hm.put(player, i+1);
            ranking[i] = player; 
        }
        
        for(String calledName:callings){
            int calledRank = hm.get(calledName);
            String frontName = ranking[calledRank-2];
            
            ranking[calledRank-1] = frontName;
            ranking[calledRank -2 ] = calledName;
            
            hm.put(frontName, calledRank);
            hm.put(calledName, calledRank -1 );
        }
        
        return ranking;
    }
}