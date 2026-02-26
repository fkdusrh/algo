import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> hm = new HashMap<>();
        
        for(String letters:keymap){
            for(int i=0;i<letters.length();i++){
                char c = letters.charAt(i);
                hm.put(c, Math.min( hm.getOrDefault(c, Integer.MAX_VALUE), i+1));        
            }
        }
        
        for(int i=0;i<targets.length;i++){
            String target = targets[i];
            int sum = 0;
            
            for(char c:target.toCharArray()){
                int cnt = hm.getOrDefault(c, -1);
                
                if(cnt == -1){
                    sum = -1;
                    break;
                }
                sum += cnt;
            }
            
            if(sum == -1)
                answer[i] = -1;
            else
                answer[i] = sum;
        }
        
        return answer;
    }
}