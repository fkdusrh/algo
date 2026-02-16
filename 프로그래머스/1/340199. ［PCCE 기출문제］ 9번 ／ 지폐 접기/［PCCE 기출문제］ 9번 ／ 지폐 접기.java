
import java.util.*;
class Solution {
    
    public int solution(int[] wallet, int[] bill) {
        int cnt = 0;
        Arrays.sort(wallet);
        
        while(wallet[0] < bill[0] ||  wallet[1] < bill[1]){
            int divided = Math.max(bill[0], bill[1]) / 2;
            int origin = Math.min(bill[0], bill[1]);
            
            bill[1] = Math.max(origin, divided);
            bill[0] = Math.min(origin, divided);
            
            cnt++;
        }
        
        return cnt;
    }
}