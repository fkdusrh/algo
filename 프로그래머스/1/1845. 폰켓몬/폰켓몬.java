class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int size = nums.length;
        boolean[] exists = new boolean[200001];
       
        for(int n:nums){
            if(!exists[n]){
                exists[n] = true;
                if((++answer) == size/2)
                    return answer;
            }
        }
        
        return answer;
    }
}