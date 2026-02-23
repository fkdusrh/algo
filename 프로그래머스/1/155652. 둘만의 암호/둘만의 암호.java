import java.util.*;
class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int idx = c-'a'; 
            int cnt=0;
            
            while(cnt < index){
                ++idx;
                idx %= (int)('z'-'a'+1);
                if(!skip.contains(Character.toString('a'+idx))){
                    ++cnt;
                }               
            }
            
            sb.append((char)((int)'a'+idx));
        }
        
        return sb.toString();
    }
}