import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder(a*b+a);
        
        for(int i=0;i<b;i++){
            for(int j= 0;j<a;j++){
                sb.append('*');
            }
            sb.append('\n');
        }
        
        System.out.println(sb.toString());
    }
}