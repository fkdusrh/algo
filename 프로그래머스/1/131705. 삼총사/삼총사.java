class Solution {// 조합
    public int solution(int[] number) {
        return combination(number, 0, 0, 0, 0) ;
    }
    
    //매개변수 (원본 배열, 삼총사 멤버, 현재 멤버 인원,순회 시작 지점, 그룹 개수)
    public int combination(int number[], int start, int sum, int memberCnt, int groupCnt){
        if(memberCnt == 3){
            return sum==0?++groupCnt:groupCnt;
        }
        
        for(int i = start;i<number.length;i++){
            groupCnt = combination(number, i+1,sum+number[i], memberCnt+1, groupCnt);
        }
        
        return groupCnt;
    }
}