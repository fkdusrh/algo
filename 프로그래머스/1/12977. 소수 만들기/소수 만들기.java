class Solution {
    public int solution(int[] nums) {
        return combination(nums,0,0,0,0);
    }
    
    public int  combination(int[] nums, int start, int sum, int pickCnt, int primeCnt){
        if(pickCnt == 3){
            int cnt=0;
            
            for(int i=1;i<= sum;i++){
                if(sum % i ==0)
                    cnt++;
            }
            
            return cnt > 2 ? primeCnt: ++primeCnt;
        }
        
        for(int i=start;i<nums.length;i++){
            primeCnt = combination(nums, i+1, sum+nums[i], pickCnt+1, primeCnt);
        }
        
        return primeCnt;
    }
}