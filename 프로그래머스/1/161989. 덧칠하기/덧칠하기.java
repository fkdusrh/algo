class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int length = 0;
        
        for(int num:section){
            if(num <= length) continue; 
            answer++;
            length = num+m-1;
        }
        
        return answer;
    }
}

//9:44