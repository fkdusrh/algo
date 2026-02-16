class Solution {
    public int[] solution(int[] numbers) {
        boolean[] exists = new boolean[200];
        int cnt=0;
        
        for(int i=0;i<numbers.length-1;i++){
            int number = numbers[i];
            
            for(int j=i+1;j<numbers.length;j++){
                if(!exists[number+numbers[j]]){
                   exists[number+numbers[j]] = true;
                   ++cnt;                
                }
            }
        }
        
        int[] answer = new int[cnt];
        int idx = 0;
        
        for(int i=0;i<200;i++){
            if(exists[i])
                answer[idx++] = i; 
        }
        
        return answer;
    }
}