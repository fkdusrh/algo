class Solution {
    public String solution(String s) {
        boolean even = true;
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
        
            if(c == ' '){
                cnt=0;
                sb.append(' ');
                continue;
            }
            
            
            if(cnt % 2 == 0){
                sb.append(Character.toUpperCase(c));
            }else{
                sb.append(Character.toLowerCase(c));
            }
            
            cnt++;
            
        }
        return new String(sb);
    }
}