import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> ls = new ArrayList<>(); 
        
        for(int num:arr){
            if(num % divisor == 0){
                ls.add(num);
            }
        }
        
        if(ls.size()==0)
            return new int[]{-1};
        
        int[] answer = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) {
            answer[i] = ls.get(i); 
        }
        Arrays.sort(answer);
        
        return answer;
    }
}