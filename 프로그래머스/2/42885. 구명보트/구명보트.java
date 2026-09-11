import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int cnt = 0;
        Arrays.sort(people);
        int startIdx = 0;
        
        for(int i=people.length-1;i>=startIdx;i--){
            cnt++;
            
            if(people[i] + people[startIdx] <= limit){
                startIdx++;
            }
        }

        return cnt;
    }
}