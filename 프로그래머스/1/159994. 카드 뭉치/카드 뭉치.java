import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> q1 = convertToQueue(cards1);
        Queue<String> q2 = convertToQueue(cards2);
        int succCard1 = 0, succCard2=0;
        
        for(String word:goal){
            if(word.equals(q1.peek()) && succCard1<2){
                q1.remove();
                succCard2 = 0;
            }else if(word.equals(q2.peek()) && succCard2<2){
                q2.remove();
                succCard1 = 0;
            }else{
                return "No";
            }
        }
        
        return "Yes";
        
        
    }
    
    public Queue<String> convertToQueue(String[] cards){
        Queue<String> q =  new LinkedList<>();
        
        for(String card:cards)
            q.add(card);
        
        return q;
        
    }
}