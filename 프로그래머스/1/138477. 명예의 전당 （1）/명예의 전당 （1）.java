import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int size = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int sc : score){
            if(pq.size() >= k && pq.peek() < sc){
                pq.poll();   
                pq.add(sc);
            }else if(pq.size() < k){
                pq.add(sc);
            }
            
            answer[size++] = pq.peek();
        }
        
        return Arrays.copyOf(answer, size);
    }
}
