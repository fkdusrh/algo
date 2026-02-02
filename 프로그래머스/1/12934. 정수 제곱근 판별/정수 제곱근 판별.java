class Solution {
    public static long solution(long n) {
        long sum = 1;
        int cnt = 0;
        long temp = n;
        
        for(long div = 2 ;div*div<= temp ;div++){
            cnt = 0;
            while(n%div==0){
                n /= div; 
                cnt++; 
            }
            if(cnt == 0)
                continue;
            if(cnt % 2 != 0) 
                return -1;
            for(int i=0;i<cnt/2;i++){ 
                sum *= div;
            }
        }
        if(n != 1)
            return -1;
        return (sum+1) * (sum + 1);
    }
}