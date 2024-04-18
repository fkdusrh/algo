import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<bridge_length;i++)
            q.add(0);
        int total = 0;
        int time = 0;
        int i=0;
        while(!q.isEmpty()){
            time++;
            total-=q.poll();
            if(i==truck_weights.length)
                continue;
            
            if(total + truck_weights[i] > weight ){
               q.add(0);
                continue;
            }
            total += truck_weights[i];
            q.add(truck_weights[i]);
            i++;
        }
        return time;
    }
}