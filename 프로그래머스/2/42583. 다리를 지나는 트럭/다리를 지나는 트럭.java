import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int cbw = 0;
        int time=0;

        Queue<Integer> bridgh = new LinkedList<>();

        for(int i=0;i<bridge_length;i++)
        bridgh.add(0);


        for(int i=0;i<truck_weights.length;i++){

            if(cbw+truck_weights[i] <= weight ){
                time++;
                cbw-=bridgh.poll();
                bridgh.add(truck_weights[i]);
                cbw+=truck_weights[i];

            }
            else{
                while(cbw+truck_weights[i]>weight){
                    time++;
                    cbw-= bridgh.poll();
                    if(cbw+truck_weights[i]<=weight){
                        bridgh.add(truck_weights[i]);
                        cbw+=truck_weights[i];
                        break;

                    }
                    else
                    bridgh.add(0);
                }



            }
        }
        while(!bridgh.isEmpty()){
            bridgh.poll();
            time++;
        }
        
        answer=time;
        return answer;
    }
}