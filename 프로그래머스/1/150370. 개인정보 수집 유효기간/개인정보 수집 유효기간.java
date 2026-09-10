import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int curDate = convertToDates(today.split("\\."));
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String term:terms){
            String[] info = term.split(" ");
            map.put(info[0], Integer.parseInt(info[1]) * 28);
        }
        
        int[] answer = new int[privacies.length];
        int size = 0;
        
        for(int i=0;i<privacies.length;i++){
            String[] info = privacies[i].split(" ");
            
            int startDate = convertToDates(info[0].split("\\."));
            int term = map.get(info[1]);
            
            if(startDate + term -1 < curDate)
                answer[size++] = i+1;
        }
        
        return Arrays.copyOf(answer, size);
    }
    
    public int convertToDates(String[] info){
        return Integer.parseInt(info[0]) * 12 * 28 + Integer.parseInt(info[1]) * 28 + Integer.parseInt(info[2]);
    }
}