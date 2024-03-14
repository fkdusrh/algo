import java.util.*;
class Solution {
    public int solution(int n) {
         int cnt = 0;
        int sum = 1;
        int inputNum=1;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(inputNum++);

        while(!q.isEmpty()){

            if(sum>=n){
                if(sum==n){
                    cnt++;
                }
                int smallNum=q.poll();
                sum-=smallNum;
                continue;
            }
            sum+=inputNum;
            q.add(inputNum++);
        }
        return cnt;
    }
}