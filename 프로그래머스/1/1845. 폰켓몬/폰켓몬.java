import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            if(map.getOrDefault(num,0) == 0){
                map.put(num,1);
                answer++;
            }
        }
        return answer > nums.length/2? nums.length/2 : answer;
    }
}