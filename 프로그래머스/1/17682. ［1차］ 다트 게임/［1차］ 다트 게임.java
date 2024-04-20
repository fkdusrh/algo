import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] result = new int[3];
        int cnt=-1;
        boolean isDouble=false;
        for(int i=0;i<dartResult.length();i++){
            char c = dartResult.charAt(i);
            
            if(c>='0' && c<='9'&& isDouble){
                result[cnt] = result[cnt] * 10 + (c-'0');
                isDouble=false;
                continue;
            }
            if(c>='0' && c<='9'){
                result[++cnt]=c-'0';
                isDouble=true;
                continue;
             }
            isDouble=false;
            
            if(c=='S')
                continue;
            if(c=='D'){
                result[cnt] *= result[cnt];
                continue;
            }
            if(c=='T'){
                result[cnt] = result[cnt] *result[cnt] *result[cnt];
                continue;
            }
            if(c=='*'){
                result[cnt]*=2;
                if(cnt>0){
                    result[cnt-1] *=2;
                }
                continue;
            }
            if(c=='#'){
                result[cnt]*=-1;
                continue;
            }    
        }
        for(int n : result)
            answer+=n;
        return answer;
    }
}