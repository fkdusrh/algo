class Solution {// 조합
    public int solution(int[] number) {
        int[] team = new int[3];
        return combination(number, team, 0, 0, 0) ;
    }
    
    //매개변수 (원본 배열, 삼총사 멤버, 현재 멤버 인원,순회 시작 지점, 그룹 개수)
    public int combination(int number[], int[] team, int memberCnt, int start, int groupCnt){
        if(memberCnt == 3){
            int sum = 0;
            for(int n : team)
                sum+=n;
            
            return sum==0?++groupCnt:groupCnt;
        }
        
        for(int i = start;i<number.length;i++){
            team[memberCnt] = number[i];
            groupCnt = combination(number, team, memberCnt+1, i+1,groupCnt);
        }
        
        return groupCnt;
    }
}