import java.util.Arrays;
class Solution {
   public int[] solution(long n) {
         int[]  test = new int[11];

        int cnt = 0;
        for(int i=0;n > 0;i++){
            test[i] =(int) (n % 10);
            n/=10;
            cnt++;

        }
        int[] answer = Arrays.copyOf(test, cnt);

        return answer;
  
    }
}