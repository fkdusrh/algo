import java.util.*;
class Solution {
    String targetWord;
    char[] aeiou = {'A','E','I','O','U'};
    boolean find = false;
    int cnt =0;
    
    public int solution(String word) {
        targetWord = word;
        recur(new char[5], 0);
        return cnt;
    }
    
    void recur(char[] arr, int idx){
        if(new String(arr, 0, idx).equals(targetWord)){
            find = true;
            return;
        }
        
        if(idx > 4)
            return;
        
        for(int i=0;i<5;i++){
            cnt++;
            arr[idx] = aeiou[i];
            
            recur(arr, idx+1);

            if(find)
                return;
        }
    }
}