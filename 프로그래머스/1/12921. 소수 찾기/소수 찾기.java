class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] isComposite = new boolean[n+1];
        
        for(int i=2;i<= n ; i++){
            if(!isComposite[i])
                answer++;
            
            if((long) i* i <= n){
                for(int j = i* i;j<=n;j+=i){
                    isComposite[j] = true;
                }
            }
                
        }
        return answer;
    }
}