class Solution {
    public int solution(String dartResult) {
        int[] nums = new int[3];
        int strIdx = -1;
        
        for(int i=0;i<dartResult.length();i++){
            char c = dartResult.charAt(i);
            
            if(c-'0' >=0 && c-'0'<=9){
                ++ strIdx;
                if(c == '1' && dartResult.charAt(i+1) =='0'){
                    nums[strIdx] = 10;
                    i += 1;
                }else{
                   nums[strIdx] = c-'0';
                }
            }else if(c=='S'){
                //x
            }else if(c == 'D'){
                nums[strIdx] *= nums[strIdx];
            }else if(c=='T'){
                nums[strIdx] *= (nums[strIdx] * nums[strIdx] );
            }else if(c =='*'){ 
                nums[strIdx] <<= 1;
                if(strIdx > 0)
                    nums[strIdx-1] <<= 1;
            }else if(c == '#'){
                nums[strIdx] *= -1;
            }
        }
        
        int sum = 0;
        for(int n: nums){
            sum+=n;
        }
        return sum;
    }
}