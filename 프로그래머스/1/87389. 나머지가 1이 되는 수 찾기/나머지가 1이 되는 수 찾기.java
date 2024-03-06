class Solution {
    public int solution(int n) {
        int answer = 0;
        int index=1;
        for(;index<n;index++){
            if(n%index==1)
               break;
        }
        return index;
    }
}