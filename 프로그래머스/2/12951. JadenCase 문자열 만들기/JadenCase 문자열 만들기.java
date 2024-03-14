class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        System.out.println((int)'2');
        String answer = "";
        boolean big = true;
        int gap = (int)'a'-(int)'A';
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == ' '){
                sb.append(" ");
                big=true;
                continue;
            }
            if(c<'A'){
                sb.append(c);
                big=false;
                continue;
            }
            c-='A';
            if(c>=gap){
                c-=gap;
            }
        
            if(big){
                sb.append((char)(c+'A'));
                big=false;
                continue;
            }
            sb.append((char)(c+'a'));
            
        }
        return sb.toString();
    }
}