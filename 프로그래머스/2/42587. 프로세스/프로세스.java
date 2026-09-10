import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Deque<int[]> q = new ArrayDeque<>();
        
        for(int i=0;i<priorities.length;i++){
            int priority = priorities[i];
            pq.offer(priority);
            
            int[] arr = new int[2];
            arr[0] = priority;
            arr[1] = i;
            q.offer(arr);
        }
        
        int cnt =0;
        
        while(!q.isEmpty()){
            int[] num = q.poll();
            
            if(pq.peek() == num[0]){
                ++cnt;
                pq.poll();
                if(num[1] == location){
                    return cnt;
                }
            }else{
                q.offer(num);
            }
            
            
        }
        
        return cnt;
    }
}