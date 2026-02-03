import java.util.*;
class Solution {
    public String solution(String s) {
        int size = s.length();
        if(s.length() % 2 ==0 ){        
            return s.substring(size/2-1,size/2+1);
        }
        return s.substring(size/2, size/2+1);
    }
}