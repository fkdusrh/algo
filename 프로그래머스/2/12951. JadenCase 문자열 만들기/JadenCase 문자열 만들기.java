import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean start = true;
        s = s.toLowerCase();
        
        for(char c:s.toCharArray()){
            if(c == ' '){
                sb.append(c);
                start = true;
                continue;
            }
            
            if(start && c >= 'a' && c<= 'z'){
                sb.append((char)(c-32));
            }else
                sb.append(c);
            
            start = false;
        }
            
        return sb.toString();
    }
}