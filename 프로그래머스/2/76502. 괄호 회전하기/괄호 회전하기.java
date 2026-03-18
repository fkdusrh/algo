import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        Map<Character, Character> hm = init();
        Stack<Character> st = new Stack<>();
        
        for(int strIdx = 0;strIdx < s.length();strIdx++){
            for(int i=0;i<s.length();i++){
                char c = s.charAt((strIdx + i) % s.length());
                
                if(st.size() >0 && st.peek() == hm.get(c))
                    st.pop();
                else
                    st.add(c);
            }
            
            if(st.isEmpty()){
                answer++;
            }
            
            st.clear();
        }
        
        return answer;
    }
    
    public HashMap<Character, Character> init(){
        HashMap<Character, Character> hm = new HashMap<>();
        
        hm.put(']','[');
        hm.put('}','{');
        hm.put(')','(');
        
        return hm;
        
    }
}