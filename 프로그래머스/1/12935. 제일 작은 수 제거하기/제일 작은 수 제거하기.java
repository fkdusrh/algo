class Solution {
    public int[] solution(int[] arr) {
        
        if(arr.length==1){
            int[] answer = {-1};
            return answer;
        }
        int minIdx=0;
        for(int i=0;i<arr.length;i++){
            if(arr[minIdx]>arr[i])
                minIdx=i;
        }
        
        int[] answer = new int[arr.length-1];
        int cnt=-1;
        for(int i=0;i<arr.length;i++){
            if(i==minIdx)
                continue;
            answer[++cnt]=arr[i];
        }
        return answer;
    }
}