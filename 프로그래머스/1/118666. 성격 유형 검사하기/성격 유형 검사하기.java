import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();
        int[] scores = {3,2,1,0,1,2,3};
        
        for(int i=0;i<survey.length;i++){
            String s = survey[i];
            int c = choices[i];
            
            if(c<4)
                map.put(s.charAt(0), map.getOrDefault(s.charAt(0),0) + scores[c-1]);
            else if(c>4)
                map.put(s.charAt(1), map.getOrDefault(s.charAt(1),0) + scores[c-1]);
        }
        
        StringBuilder sb = new StringBuilder();
        char[][] TYPE = {{'R','T'}, {'C','F'}, {'J','M'},{'A','N'}};
        
        for(char[] t: TYPE){
            char c = map.getOrDefault(t[0],0) >= map.getOrDefault(t[1],0)? t[0] : t[1];
            sb.append(c);
        }
        return sb.toString();
    }
}