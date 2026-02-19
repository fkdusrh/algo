import java.util.*;
class Solution {
    public String solution(String new_id) {
        
        new_id = new_id.toLowerCase();
        new_id = except(new_id);
        new_id = convertSingle(new_id);
        new_id = removeDotForEndOrStart(new_id);
        new_id = addFirst(new_id);
        new_id = cutLength(new_id);
        new_id = addLength(new_id);
        
        return new_id;
    }
    
    public String except(String id){
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<id.length();i++){
            char c = id.charAt(i);
            
            if(c == '.' || c== '_'|| c=='-' || (c-'0' >= 0 && c-'0'<=9 )|| (c-'a'>=0 && c-'a'<=25))
                sb.append(c);
        }
            
            return sb.toString();
    }
    
    public String convertSingle(String id){
        boolean successive = false;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<id.length();i++){
            if(id.charAt(i) != '.') {
                sb.append(id.charAt(i));
                successive = false;
            } else if(id.charAt(i) == '.' && !successive){
                sb.append(id.charAt(i));
                successive = true;
            }
        }

        return sb.toString();
    }
    
    public String removeDotForEndOrStart(String id){
        if(id.startsWith("."))
            id = id.substring(1);
        if(id.endsWith("."))
            id = id.substring(0, id.length() - 1);
        
        return id;
    }
    
    public String addFirst(String id){
        if(id.length() == 0)
            return "a";
        
        return id;
    }
    
    public String cutLength(String id){
        if(id.length() >15){
            id = id.substring(0,15);
        }else{
            return id;
        }
        
        if(id.endsWith("."))
            id = id.substring(0,14);
        
        return id;
    }
    
    public String addLength(String id){
        if(id.length()>2)
            return id;
        
        StringBuilder sb = new StringBuilder();
        char last = id.charAt(id.length()-1);
        sb.append(id);
        
        while(sb.length()<=2){
            sb.append(last);
        }
        
        return sb.toString();
    }
    
}