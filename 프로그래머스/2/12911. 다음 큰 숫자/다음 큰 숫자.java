class Solution {
    public int solution(int n) {
        int cntOfN = Integer.bitCount(n);
        int next = n+1;
        
        while(Integer.bitCount(next) != cntOfN){
            next++;
        }
        
        return next;
    }
}