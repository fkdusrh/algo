class Solution {
    public boolean solution(int x) {
        boolean answer = true;

        int copyX=x;
        int sum=0;
        for(int i=0;copyX>0;i++){
            sum+=copyX%10;
            copyX/=10;
        }
        if(x%sum==0)
            return true;

        return false;
    }
}