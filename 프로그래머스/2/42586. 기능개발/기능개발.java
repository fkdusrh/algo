import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<progresses.length;i++){
            int remain = 100 - progresses[i];
            int needDay = (remain + speeds[i] - 1) / speeds[i];
            
            q.offer(needDay);
        }
        
        List<Integer> ls = new ArrayList<>();
        
        while(!q.isEmpty()){
            int cnt = 1;
            int maximum = q.poll();
            
            while(!q.isEmpty() && q.peek() <= maximum){
                q.poll();
                cnt++;
            }
            
            ls.add(cnt);
        }
        
        return ls.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
