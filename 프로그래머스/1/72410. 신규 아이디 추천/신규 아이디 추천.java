/*
1. 3~15자 사이
2. 소문자, 숫자, -, _, .
    . : 처음과 끝, 연속 X
    
변환
1. 대문자 -> 소문자
2. 소문자, 숫자, -, _ , . 나머지는 제외
3. .. -> . 치환
4. 처음과 끝 . 제거
5. 빈 문자열이면 a 대입
6. 16자 이상이면, 처음15개만 남기기
    ->마지막에 . 남으면 제거
    
7. 2자 이하라면, 마지막 문자를 3자 이상 될때까지 반복해서 붙이기
*/
import java.util.*;
class Solution {
    public String solution(String new_id) {
       
        //1. 대문자 -> 소문자
        new_id= new_id.toLowerCase();
        //2. 소문자, 숫자, -, _ , . 나머지는 제외
        new_id = new_id.replaceAll("[^a-z0-9-\\.\\_]","")
            .replaceAll("\\.{2,}",".") //3.  ..연속 -> . 로 치환
            .replaceAll("^\\.|\\.$","");//4. 처음과 끝 . 제거
   
        //5. 빈 문자열이면 a 대입
        if(new_id.length()==0)
            new_id="a";
        //6. 15자 초과시 제거
        if(new_id.length()>15)
            new_id = new_id.substring(0,15);
        //6.2 만약 뒤가 .이면 제거
        new_id = new_id.replaceAll("\\.$","");
        //7. 2자 이하라면, 마지막 문자를 3자 이상 될때까지 마지막 문자 반복해서 붙이기
        
        if(new_id.length()<3){            
            StringBuilder sb = new StringBuilder(new_id);
            char last=sb.charAt(sb.length()-1); 
            while(sb.length()<3){
                 sb.append(last);
             } 
            new_id = sb.toString();
        }
        
        return new_id;
    }
}