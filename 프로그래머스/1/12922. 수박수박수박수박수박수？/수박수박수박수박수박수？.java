class Solution {
    public String solution(int n) {
        String[] arr = {"수","박"};
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append(arr[(i+1)%2]);
        }
        String answer = sb.toString();
        return answer;
    }
}