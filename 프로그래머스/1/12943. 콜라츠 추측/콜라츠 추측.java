class Solution {
    public int solution(int num) {

        int cnt=0;

        long number = num;

        while(cnt<=500 && number!=1){
            if(number%2==0)
                number/=2;
            else{
                number *=3;
                number+=1;
            }
            cnt++;
        }
        if(cnt<=500 && number == 1)
            return cnt;
        return -1;
    }
}