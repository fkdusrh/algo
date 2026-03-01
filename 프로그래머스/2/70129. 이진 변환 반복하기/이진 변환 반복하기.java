import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        StringBuilder sb = new StringBuilder(s);
        int number = Integer.MAX_VALUE;
        List<Integer> ls = new ArrayList<>();
        int removedZeroCnt = 0;
        int circle = 0;
        
        while(number != 1){
            int cnt = 0;
            
            for(int i=0;i<s.length();i++){
                char c= s.charAt(i);
                
                if(c=='0')
                    cnt++;
            }
            
            number = s.length() - cnt;
            s = toBinary(number);
            
            removedZeroCnt += cnt;
            circle++;
        }

        return new int[]{circle, removedZeroCnt};
    }
    
    public String toBinary(int n){      
        StringBuilder sb = new StringBuilder();
        
        while(n>0){
            sb.append(n % 2);
            n /= 2;
            
        }
        
        return sb.toString();
    }
}