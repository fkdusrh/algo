import java.util.*;
class Solution {
    
    
    public static int answerCnt = 0 ;
 
    public  int solution(int[] number) {
        int answer = 0;
        int[] comb = new int[3];
      
        combination(number,comb,0,0);
        answer = answerCnt;
        return answer;
    }

    public  void combination(int[] number, int[] comb, int turn, int cnt){

        if(cnt>2){
            checkTripleZero(comb);
            return;
        }

        if(turn >= number.length){
            return;
        }

        comb[cnt] = number[turn];

        combination(number, comb, turn+1, cnt+1);

        combination(number, comb, turn+1, cnt);
    }

    private static void checkTripleZero(int[] comb) {
        int sum = 0;

        for(int a : comb){
            sum += a;
        }
        if(sum == 0){
            System.out.println(Arrays.toString(comb));
            answerCnt++;
        }
    }
}