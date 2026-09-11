import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 0, right = 0;
        Arrays.sort(times);
        
        
        for(int time:times){
            left = Math.min(time, left);
            right = Math.max(time, right);
        }
        
        left *= n;
        right *= n;
        
        while(left<=right){
            long mid = (left+right)/2;
            long cnt = 0;
            
            for(int i=times.length-1;i>=0;i--){
                cnt += mid / times[i];
            }
            
            if(cnt >= n){
                right = mid-1;
            }else{
                left = mid +1;
            }
        }
        
        return left;
    }
}