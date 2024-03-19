class Solution {
    final static int three = 3;
    static int cnt=0;
    static int answer=0;
    
    public int solution(int[] nums) {
      
        combination(nums,0,0,0);
            
        return answer;
    }
    
    public static void combination(int[] nums, int start,int cnt,int sum){
        if(cnt==three){
            for(int i=2;i<sum;i++){
                if(sum%i==0)
                    return;
            }
            answer++;
            return;
        }
        
        if(nums.length <= start)
            return;
        
        combination(nums,start+1,cnt+1,sum+nums[start]);
        combination(nums,start+1,cnt,sum);
        
    }
}