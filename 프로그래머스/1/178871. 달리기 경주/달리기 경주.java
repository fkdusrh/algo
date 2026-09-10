import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        HashMap<String, Integer> rankingMap = new HashMap<>();
        String[] board = new String[players.length];
        
        for(int i=0;i<players.length;i++){
            rankingMap.put(players[i], i + 1);
            board[i] = players[i];
        }
        
        for(String calling:callings){
            int beforeRank = rankingMap.get(calling);
            String downName = change(board, calling, beforeRank);
            rankingMap.put(calling, beforeRank - 1);
            rankingMap.put(downName, rankingMap.get(downName)+1);
        }
        
        return board;
    }
    
    private String change(String[] ranking, String upName, int index){
        String tmp = ranking[index-2];
        ranking[index - 2 ] = upName;
        ranking[index - 1] = tmp;
        
        return tmp;
    }
}