import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        Map<String, Boolean> hm = new HashMap<>();
        char preLetter = words[0].charAt(words[0].length()-1);
        
        for(int i=0;i<words.length;i++){
            String word = words[i];
            
            if(hm.containsKey(word))
                return new int[]{ i % n + 1, i/n+1};
            if(i>0 && preLetter != word.charAt(0))
                return new int[]{ i % n + 1, i/n+1};
            
            preLetter = word.charAt(word.length()-1);
            hm.put(word,true);
        }

        return new int[]{0,0};
    }
}