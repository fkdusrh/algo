class Solution {
     boolean solution(String s) {
        boolean answer = true;
        int pCnt = 0;
        int yCnt = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'p' || c == 'P') {
                pCnt++;
                continue;
            }
            if (c == 'y' || c == 'Y')
                yCnt++;
        }

        if(pCnt==yCnt)
            return true;


        return false;
    }
}