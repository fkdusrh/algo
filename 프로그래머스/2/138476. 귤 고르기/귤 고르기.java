import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        List<Integer> ls = new ArrayList<>();        
        Arrays.sort(tangerine);
        
        int curSize = tangerine[0];
        int cnt =0;
        
        for(int t : tangerine ){
            if(t == curSize){
                cnt++;
            }else{
                ls.add(cnt);
                cnt = 1;
                curSize = t;
            }
        }
        ls.add(cnt);
        Collections.sort(ls);
        
        int sum = 0;
        for(int i=ls.size()-1; i>=0;i--){
            sum += ls.get(i);
            answer++;
            
            if(sum >= k)
                break;
        }
        
        return answer;
    }  
}