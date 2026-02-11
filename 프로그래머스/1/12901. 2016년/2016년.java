class Solution {
    public String solution(int a, int b) {
        String[] dayOfWeek = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int[] dayOfMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sumDay = 0;
        
        for(int i=1;i<a;i++){
            sumDay += dayOfMonth[i-1];
        }
                                                                                   sumDay += b;              
        sumDay %= 7;
        
        return dayOfWeek[sumDay];
    }
}