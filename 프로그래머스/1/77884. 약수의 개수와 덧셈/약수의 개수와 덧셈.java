class Solution {
    public int solution(int left, int right) {
        int sum = 0;
        
        for(int n=left;n<=right;n++){                
            int root = (int)Math.sqrt(n);
            
            if(root * root == n){
                sum-=n;
            }else{
                sum+=n;
            }
        }  
        
        return sum;
    }
}