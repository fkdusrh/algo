import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0;i<score.length;i++){
            int s = score[i];
            
            if(pq.size() < k){
                pq.offer(s);
            }else {
                int lowest = pq.poll();
                
                if (lowest < s) {
                    pq.offer(s);
                } else {
                    pq.offer(lowest);
                }   
            }
            
            answer[i] = pq.poll();
            pq.offer(answer[i]);
        }
        return answer;
    }
}