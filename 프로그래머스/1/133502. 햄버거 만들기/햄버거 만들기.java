class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int[] s = new int[ingredient.length];
        int top = -1;
        
        for(int i=0;i<ingredient.length;i++){
            s[++top] = ingredient[i];
            
            if(top > 2){
                if(s[top]==1 && s[top-1] == 3 && s[top-2] ==2 && s[top-3] == 1){
                    top -= 4;
                    answer++;
                }
            }
        }
        
        return answer;
    }
}

