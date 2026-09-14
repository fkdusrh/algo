import java.util.*;
class Solution {//4:05
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int vidioSec = convertToSec(video_len);
        int posSec = convertToSec(pos);
        int opStartSec = convertToSec(op_start);
        int opEndSec = convertToSec(op_end);
        
        for(String comm:commands){
            if(opStartSec <= posSec && posSec <= opEndSec){
                posSec = opEndSec;
            }
            
            if(comm.equals("next")){
                posSec += 10;
            }else{
                posSec -= 10;
            }
            
            if(posSec < 0){
                posSec = 0;
            }else if(posSec > vidioSec){
                posSec = vidioSec;
            }else if(opStartSec <= posSec && posSec <= opEndSec){
                posSec = opEndSec;
            }
            
            System.out.println("->"+posSec);
            
        }
        
        return convertToString(posSec);
    }
    
    int convertToSec(String s){
        String[] info = s.split(":");
        int min = Integer.parseInt(info[0]);
        int sec = Integer.parseInt(info[1]);
        
        return sec + min * 60;
    }
    
    String convertToString(int n){
        int min = n/60;
        int sec = n%60;
        
        String m, s;
        
        if(min>=10)
            m = Integer.toString(min);
        else
            m = "0" + Integer.toString(min);
        
        if(sec>=10)
            s = Integer.toString(sec);
        else
            s = "0" + Integer.toString(sec);
        
        return m+ ":"+s ;
    }
}