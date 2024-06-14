import java.util.*;
class Solution {
    
    public static HashMap<Character,Character> map ;
    public int index;
    public int solution(String word) {
        int answer = 0;
        int index = 0;
        map = new HashMap<>();
        map.put('A','E');
        map.put('E','I');
        map.put('I','O');
        map.put('O','U');
        StringBuilder sb = new StringBuilder();
        //A~AAAAA 까지는 수작업
        if(word.equals("A"))
            return 1;
        if(word.equals("AA"))
            return 2;
        if(word.equals("AAA"))
            return 3;
        if(word.equals("AAAA"))
            return 4;
        
        while(!sb.toString().equals(word)){    
            
            if(sb.length()<5){
                sb.append("A");
                index++;
                continue;
            }
            
            int lastIndex = sb.length() - 1;
            char lastChar = sb.charAt(lastIndex);
            if(lastChar!='U')
                sb.setCharAt(lastIndex, map.get(lastChar));
            else
                sb = upper(sb);
            index++;    
            
            if(sb==null){
                break;
            }
        }   
        return index;
    }
    
    public static StringBuilder upper(StringBuilder sb){
        
        for(;sb.length()>0;){
            int lastIndex = sb.length() - 1;
            sb.deleteCharAt(lastIndex--);
            
            char front = sb.charAt(lastIndex);
            if(front!='U'){
                sb.setCharAt(lastIndex, map.get(front));
                return sb;
            }
             
        }        
        return null;
    }
}