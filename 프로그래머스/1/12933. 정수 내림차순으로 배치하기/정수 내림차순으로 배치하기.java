import java.util.Arrays;

class Solution {
      public long solution(long n) {
        long answer = 0;
        int[] arr = new int[10];
        int cnt=0;

        for(int i=0;n>0;i++){
            arr[i]= (int) (n%10);
            n /=10;
            cnt++;
        }
        int[] fitArr = Arrays.copyOf(arr,cnt);

        System.out.println(Arrays.toString(fitArr));
        Arrays.sort(fitArr);

        int up=1;
       for(int i=fitArr.length-1;i>=0;i--){
           int num = fitArr[i];


           answer *=10;
           answer += num;
       }
        return answer;
    }
}