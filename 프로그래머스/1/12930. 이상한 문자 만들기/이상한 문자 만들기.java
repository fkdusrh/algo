import java.util.*;

class Solution {
   public  String solution(String s) {

        System.out.println((int) 'a');
        String answer = "";
        StringTokenizer st = new StringTokenizer(s);
        int change = 'A';
        int turn = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append(" ");
                turn = 0;
                continue;
            }
            if (s.charAt(i) >= (int) 'a') {
                if (turn % 2 == 0)
                    sb.append((char) (s.charAt(i) - (int) 'a' + (int) 'A'));
                else {
                    sb.append((char) s.charAt(i));
                }
                turn++;
            }else{//대문자
                if(turn%2==0){
                    sb.append((char) s.charAt(i));

                }else{
                    sb.append((char) (s.charAt(i) - (int) 'A' + (int) 'a'));
                }
                turn++;
            }


        }
        return sb.toString();
    }
}