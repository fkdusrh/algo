import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        StringBuilder sb = new StringBuilder();
        
        for(int h=citations[citations.length-1];h>=0;h--){
            int cnt = 0;

            for(int citation : citations){
                if(citation >= h)
                    cnt++;
            }
            
            if(cnt >= h && citations.length-cnt <= h){
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}