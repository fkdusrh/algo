import java.util.*;
class Solution { 
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i=0;i<n;i++){
            int merged = arr1[i] | arr2[i];
            char[] result = new char[n];
            
            for(int j=0;j<n;j++){ 
                result[n-j-1] = (((merged >> j) & 1) == 1 )? '#' : ' ';     
            }
            answer[i] = new String(result);
        }

        return answer;
    }
}