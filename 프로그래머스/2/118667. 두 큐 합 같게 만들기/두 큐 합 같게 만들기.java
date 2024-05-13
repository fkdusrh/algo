import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1=0,sum2=0;
        for(int i=0;i<queue1.length;i++){
            q1.add(queue1[i]);
            sum1+=queue1[i];
        }
        for(int i=0;i<queue2.length;i++){
            q2.add(queue2[i]);
            sum2+=queue2[i];
        }

        int cnt=0;
        while(true){
            if(sum1==sum2) break;

            cnt++;
            if(sum1>sum2){
                int n=q1.poll();
                sum1-=n;
                sum2+=n;
                q2.add(n);
            }
            else{
                int n=q2.poll();
                sum2-=n;
                sum1+=n;
                q1.add(n);
            }

            if(cnt>queue1.length+queue2.length+2) {
                cnt=-1;
                break;
            }
        }
        answer=cnt;
        return answer;
    }
}