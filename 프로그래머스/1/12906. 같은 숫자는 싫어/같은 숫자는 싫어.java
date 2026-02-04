import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int answer[] = new int[arr.length];
        int size = 0;
        
        
        answer[size++] = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i] != arr[i-1]){
                answer[size++] = arr[i];
            }
        }
        return Arrays.copyOf(answer, size);
    }
}