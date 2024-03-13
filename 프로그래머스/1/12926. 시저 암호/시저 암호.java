import java.util.*;
class Solution {
    public String solution(String s, int n) {
        
        String answer = "";
        StringBuilder sb = new StringBuilder();
        System.out.println((int)'z');//-25
        int alphabetCnt=26;
        n%=alphabetCnt;
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            
            if(c==' '){
                sb.append(" ");
                continue;
            }
            
            //소문자
            if(c >= 'a'){
                if(c + n > 'z'){
                   sb.append((char)((c+n-(int)'a') % alphabetCnt+'a'));
                    continue;
                }
                 sb.append((char)(c+n));
                continue;
            }
            
            //대문자
             if(c >= 'A'){
                if(c + n > 'Z'){
                   sb.append((char)((c+n-(int)'A') % alphabetCnt+'A'));
                    continue;
                }
                 sb.append((char)(c+n));
                continue;
            }
        }
        return sb.toString();
    }
}