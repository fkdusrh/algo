

class Solution {
    public int[] solution(int n, int m) {
        int max = Math.max(n, m);
        int min = Math.min(n, m);
        
        while(min>0){ 
            int temp = max % min;
            max = min;
            min = temp;
        }
        
        int lcm = n /max * m;     
        
        return new int[]{max,lcm};
    }
}