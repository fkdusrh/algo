class Solution {
    public long solution(int a, int b) {
        long answer = 0;

        int start = b;
        int end = a;
        if (a < b) {
            start = a;
            end = b;
        }

        for (;start<=end;start++){
            answer+=start;
        }
            return answer;
    }
}