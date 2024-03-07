import java.util.*;

public class Solution {
 public int[] solution(int []arr) {
        int[] answer = new int[arr.length];
        int cnt=0;
        answer[0]=arr[0];

        for(int i=1;i<arr.length;i++){
            if(arr[i-1] != arr[i])
                answer[++cnt] = arr[i];
        }

        int[] fitArr = new int[cnt];
        fitArr = Arrays.copyOf(answer, cnt+1);

        return fitArr;
    }
}