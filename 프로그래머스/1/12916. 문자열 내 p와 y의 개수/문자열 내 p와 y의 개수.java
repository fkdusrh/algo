class Solution {
    boolean solution(String s) {
        int cntP = 0, cntY = 0;
        
        for(int i=0;i<s.length();i++){
            char c = Character.toLowerCase(s.charAt(i));
            if(c=='p'){
                cntP++;
            }else if(c=='y'){
                cntY++;
            }
        }
        return cntP==cntY;
    }
}