class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        boolean[] isWinsNum = new boolean[45];
        for(int n:win_nums){
            isWinsNum[n-1] = true;

        }
        
        int winCnt=0, removeNumCnt=0;
        for(int n:lottos){
            if(n==0){ 
                ++removeNumCnt;
            }else if(isWinsNum[n-1]) 
                ++winCnt;
        }

        int high = 7 - (winCnt+removeNumCnt);
        if(winCnt + removeNumCnt < 1)
            high = 6;
        
        int low = 7 - winCnt;
        if(winCnt < 2)
            low = 6;
        
        return new int[] {high,low};
    }
}
