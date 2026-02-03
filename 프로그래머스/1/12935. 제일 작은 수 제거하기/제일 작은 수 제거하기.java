import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length==1)
            return new int[]{-1};
        
        int min = arr[0];
        
        for(int number:arr){
            if(min>number)
                min = number;
        }
        
        int[] answer = new int[arr.length-1];
        int idx = 0;
        
        for(int number : arr){
            if(number!=min)
                answer[idx++] = number;
        }
        
        return answer;
    }
}