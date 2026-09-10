import java.util.*;
class Solution {
    public int solution(String numbers) {
        int[] nums = new int[numbers.length()];
        for(int i=0;i<numbers.length();i++){
            nums[i] = numbers.charAt(i)-'0';
        }
        return reputation(new boolean[10], nums, new HashSet<Integer>(), 0);
    }
    
    private int reputation(boolean[] visit, int[] numbers, HashSet<Integer> set, int number){
        if(number >1 && isPrime(number))
            set.add(number);
        
        for(int i=0;i<numbers.length;i++){
            if(visit[i])
                continue;
            
            visit[i] = true;
            reputation(visit,numbers,set, number *10 + numbers[i]);
            visit[i]= false;
        }
        
        return set.size();
    }
    
    private boolean isPrime(int number){
        if(number <2) 
            return false;
        
        for(int i=2;i*i<=number;i++){
            if(number% i == 0)
                return false;
        }
        
        return true;
    }
    
    
}