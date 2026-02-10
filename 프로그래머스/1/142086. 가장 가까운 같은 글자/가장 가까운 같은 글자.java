import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> hm = new HashMap<>();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            System.out.print(c+"] ");
            
            int idx = hm.getOrDefault(c, -1);
            if(idx == -1){ 
                answer[i] = -1;
                hm.put(c, i);
            }
            else{ 
                hm.put(c, i); 
                answer[i] = i - idx; 
            }
            System.out.println();
        }
        return answer;
    }
}