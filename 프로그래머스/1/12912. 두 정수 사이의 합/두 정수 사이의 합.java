class Solution {
    public long solution(int a, int b) {
        if(a==b)
            return (long)a;
        int start = Math.min(a,b);
        int end = Math.max(a,b);
        
        long answer = 0;
        while(end>=start){
            answer +=start;
            start ++;
        }
        return answer;
    }
}