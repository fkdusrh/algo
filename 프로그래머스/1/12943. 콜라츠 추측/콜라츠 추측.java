class Solution {
    public int solution(int num) {
        long n = num;
        
        for(int cnt = 0;cnt<=500;cnt++){     
            if(n == 1){
                return cnt;
            }   
            
            n = n % 2 == 0 ? n /= 2 : n * 3 + 1;              
        }
        return -1;
    }
}