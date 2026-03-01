import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = new int[privacies.length];
        int tYear = Integer.parseInt(today.substring(0,4)) ;
        int tMonth = Integer.parseInt(today.substring(5,7));
        int tDay = Integer.parseInt(today.substring(8,10));        
        Map<Character, Integer> hm = new HashMap<>();
        
        for(String term:terms)
            hm.put(term.charAt(0), Integer.parseInt(term.substring(2, term.length())));
        
        int idx= 0;
        
        for(int i=0;i<privacies.length;i++){
            String privacie = privacies[i];           
   
            int pYear = Integer.parseInt(privacie.substring(0,4));
            int pMonth = Integer.parseInt(privacie.substring(5,7));
            int pDay = Integer.parseInt(privacie.substring(8,10));
            
            int term = hm.get(privacie.charAt(privacie.length()-1));
            
            if(pDay > 1)
                pDay -= 1;
             else{
                pDay = 28 ;
                pMonth -= 1;   
                 if(pMonth == 1){
                     pMonth = 12;
                     pYear -= 1;
                 }
             }   

            int month0 = (pMonth - 1) + term;
            pYear += month0 / 12;
            pMonth = (month0 % 12) + 1;
            
            if(pYear <tYear)
                answer[idx++] = i+1;
            else if(pYear == tYear && pMonth < tMonth)
                answer[idx++] = i+1;
            else if(pYear == tYear && pMonth == tMonth && pDay < tDay)
                answer[idx++] = i+1;
        }
        
        return Arrays.copyOf(answer,idx);
    }
    
    
}