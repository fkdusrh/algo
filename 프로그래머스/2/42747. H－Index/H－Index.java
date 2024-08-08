import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int hIndex = 0;

        Arrays.sort(citations);
		
        for(int i = 0; i < citations.length; i++) {
            int h = citations.length - i; 
            
            if(citations[i] >= h) {
                hIndex = h;
                break;
            }
        }

        return hIndex;
    }
}
