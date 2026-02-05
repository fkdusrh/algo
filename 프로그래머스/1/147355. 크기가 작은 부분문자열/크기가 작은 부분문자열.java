/*
1. for 순회 i=0;i<t.length()-p.length;i++
    1) subString(i, i+p.length) 
*/
import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long numP = Long.parseLong(p);
        int size = p.length();
        
        for(int i=0;i<=t.length()-size;i++){
            if(Long.parseLong(t.substring(i,i+size)) <= numP ){
                answer++;
            }
        }
        
        return answer;
    }
}