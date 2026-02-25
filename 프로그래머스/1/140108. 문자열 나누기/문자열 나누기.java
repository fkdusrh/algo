class Solution {
    public int solution(String s) {
        int answer = 0;
        char firstLetter = s.charAt(0);
        int firstLetterCnt = 0;
        int otherLetterCnt = 0;
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            
            if(firstLetterCnt == 0){
                firstLetter = c;
                firstLetterCnt++;
            }else if(c == firstLetter){
                firstLetterCnt++;
            }else{
                otherLetterCnt++;
            }
            
            if(firstLetterCnt == otherLetterCnt){
                firstLetterCnt = 0;
                otherLetterCnt = 0;
                answer++;
            }else if(i == s.length() -1)
                answer++;
        }
        
        return answer;
    }
}