import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int sum = 0;
        
        for(int i=1;i<=number;i++){
            int root = (int) Math.sqrt(i);
            int cnt = 0;

            for(int j=1;j<=root;j++){
                if(i%j == 0){
                    cnt++;
                }
            }
            
            cnt *= 2;
            if(root * root == i){
                --cnt;
            }
            
            sum += cnt > limit? power : cnt;
        }
        return sum;
    }
}