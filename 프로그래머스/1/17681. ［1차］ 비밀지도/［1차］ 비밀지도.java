class Solution { 
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        char[][] chars = new char[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){ 
                int p = arr1[i] % 2;
                int q = arr2[i] % 2;
                chars[i][n-j-1] = (p+q>0)?'#':' ';
                
                arr1[i] /= 2;                
                arr2[i] /= 2;
            }
        }
        
        for(int i=0;i<n;i++){
            answer[i] = new String(chars[i]);
        }
        return answer;
    }
}