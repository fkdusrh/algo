class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i=0;i<absolutes.length;i++){
            int number = absolutes[i];
            if(!signs[i])
                number*=-1;

            answer+=number;
        }
        return answer;
    }
}