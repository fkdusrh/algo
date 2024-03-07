class Solution {
//윤년 : 2월 29일이 있는 날.
/*
1-31
2-29
3-31
4-30
5-31
6-30
7-31
8-31
9-30
10-31
11-30
12-31

*/
    public String solution(int a, int b) {
        int[] monthsDay = {31,29,31,30,31,30,31,31,30,31,30,31};
        int sum =0;
        for(int i=0;i<a-1;i++){
            sum+=monthsDay[i];
        }
        sum+=b;
        
        int day = sum%7;
        if(day==0)
            return "THU";
        if(day==1)
            return "FRI";
        if(day==2)
            return "SAT";
        if(day==3)
            return "SUN";
        if(day==4)
            return "MON";
        if(day==5)
            return "TUE";

            return "WED";
    }
}