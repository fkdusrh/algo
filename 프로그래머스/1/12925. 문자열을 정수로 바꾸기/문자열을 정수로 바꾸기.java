class Solution {
     public int solution(String s) {
        int answer = 0;

        int start = s.length() - 1;
        int sum=0;
        int cnt=1;

        for (int i = 0; start - i >= 0; i++) {

            if( s.charAt(start - i) =='-'){
                sum*=-1;
                break;
            }
            if( s.charAt(start - i) =='+'){
                break;
            }

            int num = s.charAt(start - i) - '0' ;
            sum+=(num*cnt);

            cnt*=10;
        }
        return sum;
    }
}