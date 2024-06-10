import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num :scoville){
            pq.offer(num);
        }
        
        while(pq.size()>0){
            int min = pq.poll();
            if(min>=K)
                return cnt;
            Integer secondMin = pq.poll();
            if(secondMin == null){
                return -1;
            }
        
            pq.offer(min + secondMin*2);
            cnt++;
        }
        
        return cnt;
    }
}
