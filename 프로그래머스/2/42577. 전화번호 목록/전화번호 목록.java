import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book,(a,b)->Integer.compare(b.length(),a.length()));
        HashMap<String,String> map = new HashMap<>();
        for(String number:phone_book){
            map.put(number,"true");
        }
        for(String number : phone_book){
            for(int length = 1;length<number.length();length++){
                if(map.containsKey(number.substring(0,length))){
                   return false;
                }
            }
        }
        return true;
    }
}