import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        boolean[] blocked = new boolean['z'-'a'+1];
        
        for(char c: skip.toCharArray())
            blocked[(int)c - 'a'] = true; 
        
        for(char c: s.toCharArray()){
            int idx = c-'a'; 
            int cnt=0;
            
            while(cnt < index){
                idx = (idx + 1) % 26;
                
                if(!blocked[idx]){
                    ++cnt;
                }               
            }
            
            sb.append((char)((int)'a'+idx));
        }
        
        return sb.toString();
    }
}