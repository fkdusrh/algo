class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        final int EXTRA = 10;
        
        for(int i=0;i<schedules.length;i++){
            int goalTime = schedules[i];
            int cnt = 0;
            
            for(int j=0;j<timelogs[0].length;j++){
                int day = ( startday + j) % 7;
                
                if(day > 0 && day < 6)
                   if(calculateTime(goalTime, EXTRA) >= timelogs[i][j])
                        cnt++;
            }
            
            if(cnt==5)
                answer++;
        }
        return answer;
    }
    
    public int calculateTime(int time, int extra){
        int min = time % 100;
        int hour = time / 100;
        
        hour += (min + extra) / 60;
        min = (min + extra) % 60;
        
        return hour*100 + min;
    }
}