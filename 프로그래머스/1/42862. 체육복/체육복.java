import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] stays = new int[n+1];

        for(int num:lost){
            stays[num] = -1;
        }      
        for(int num:reserve){
            stays[num] += 1;
        }
        
        for(int i=1;i<=n;i++){
            if(stays[i]<=0) continue;
            
            if(i-1 > 0 && stays[i-1]<0 ){
                stays[i-1] += 1;
                stays[i] -= 1;
            } else if(i+1<=n && stays[i+1]<0){
                stays[i+1] += 1;
                stays[i] -=1;
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (stays[i]>=0) answer++;
        }
        return answer;
    }

}
