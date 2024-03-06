import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr, int divisor) {
       int[] answer = new int[arr.length];
       int cnt=-1;

        for(int i=0;i<arr.length;i++){
            if(arr[i]%divisor==0)
                answer[++cnt]=arr[i];
        }
        if(cnt==-1){
            int[] noneArr ={-1};
               return noneArr;
        }
         
        int[] fitArr = new int[cnt+1];
        fitArr = Arrays.copyOf(answer,cnt+1);
        Arrays.sort(fitArr);
        return fitArr;
    }
}