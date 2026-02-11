class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        int alphaCnt = 'Z'-'A'+1;
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            
            if(c != ' ') {
                char start = c >='A' && c<='Z'?'A':'a';
                int idx = c+n - start;
                
                idx %= alphaCnt;
                c = (char) (start + idx);
            }
            
            sb.append(c);            
        }
        return sb.toString();
    }
}