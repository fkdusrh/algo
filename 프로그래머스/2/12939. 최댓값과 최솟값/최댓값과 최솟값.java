import java.util.*;
class Solution {
    public String solution(String s) {
         String answer = "";
       int min = Integer.MAX_VALUE;
       int max = Integer.MIN_VALUE;

       StringTokenizer st = new StringTokenizer(s);

        while(st.hasMoreElements()){
            String n = st.nextToken();
            int number=0;
            boolean minus =false;

            for(int i=0;i<n.length();i++){
                if(n.charAt(i)=='-'){
                    minus = true;
                    continue;
                }

                number*=10;
                number+=(n.charAt(i)-'0');
            }

            if(minus)
                number*=-1;

           if(min>number)
               min=number;
           if(max<number)
               max=number;

        }


        return min+" "+max;
    }
}