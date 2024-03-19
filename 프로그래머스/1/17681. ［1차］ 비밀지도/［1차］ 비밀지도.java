import java.util.*;

class Solution {
    static char[][] map ;
    static int n;
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        String[] answer = new String[n];
        map = new char[n][n];

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){


            String s1 = String.format("%" + n + "s", Integer.toBinaryString(arr1[i])).replace(' ', '0');
    String s2 = String.format("%" + n + "s", Integer.toBinaryString(arr2[i])).replace(' ','0');
            
          
            

            consultBlock(s1,s2,i);

        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(map[i][j]);
            }
           answer[i]=sb.toString();
            sb.setLength(0);
        }
        return answer;
    }
    
     private void consultBlock(String s1, String s2,int row) {
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)=='1' || s2.charAt(i)=='1'){
                map[row][i]='#';
                continue;
            }
            map[row][i]=' ';
        }
       
    }
}

