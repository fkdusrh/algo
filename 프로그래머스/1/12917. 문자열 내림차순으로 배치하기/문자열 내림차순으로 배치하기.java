import java.util.*;
class Solution {
   public String solution(String s) {

        System.out.println((int)'z');
        System.out.println((int)'Z');
        int[] arr = new int[s.length()];
        for(int i=0;i<s.length();i++){
            arr[i]=(int)s.charAt(i);
        }
        Arrays.sort(arr);
        char[] charArr = new char[arr.length];

        for(int i=0;i<arr.length/2;i++){
            int tmp = arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=tmp;
        }

        StringBuilder sb  = new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append((char)arr[i]);
        }
        String answer = sb.toString();

        return answer;

    }
}