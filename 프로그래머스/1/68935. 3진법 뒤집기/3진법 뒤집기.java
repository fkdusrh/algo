class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        while(n>0){
            sb.append(n % 3);
            n /= 3;
        }
        
        String s = new String(sb);
        int size = s.length();
        int num = 1;
        
        for(int i=0;i<s.length();i++){
            answer = answer * 3 + s.charAt(i)-'0';
        }
        
        return answer;
    }
}