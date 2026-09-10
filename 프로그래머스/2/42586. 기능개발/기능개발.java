import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[progresses.length];
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int progress:progresses){
            q.offer(progress);
        }
        
        int jobIdx = 0, turn = 0,time = 0;
        
        while(!q.isEmpty()){
            int cnt = 0;
            time++;

            while(jobIdx < progresses.length){
                if(q.peek() + time * speeds[jobIdx] >=100){
                    q.poll();
                    cnt++;
                    jobIdx++;
                }else{
                    break;
                }
            }
            
            if(cnt>0){
                  answer[turn++] = cnt;
            }
        }
        
        return Arrays.copyOf(answer,turn);
    }
}