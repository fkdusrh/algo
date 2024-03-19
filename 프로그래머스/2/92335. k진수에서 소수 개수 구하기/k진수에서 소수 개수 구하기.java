import java.util.*;
class Solution {
     public int solution(int n, int k) {
        int answer = -1;
        String s = Integer.toString(n,k);
        System.out.println(s);
        String[] st = s.split("0");
        System.out.println(Arrays.toString(st));
        return checkFrimes(st);
    }

    private static int checkFrimes(String[] st) {
       int cnt=0;

       for(int i=0;i<st.length;i++){
            if(st[i].equals("")) {
               continue;
           }
           if(checkFrime(st[i])){
                cnt++;
            }
       }
            

       return cnt;
    }

    private static boolean checkFrime(String s) {
        long n = Long.parseLong(s,10);
        if(n==1)
            return false;
        for(long i=2;i*i<=n;i++){
            if(n%i==0)
                return false;
        }
        return true;

    }

}