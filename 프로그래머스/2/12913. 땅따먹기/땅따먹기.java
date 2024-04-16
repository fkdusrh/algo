import java.util.*;
class Solution {
    int solution(int[][] land) {
        int [][] dp = new int[land.length][4];
        dp[0]=land[0];
        
        for(int i=1;i<land.length;i++){

            for(int j=0;j<4;j++){
                int max = 0;
                for(int k=0;k<4;k++){
                    if(j==k)
                        continue;
                    if(max<dp[i-1][k])
                        max = dp[i-1][k];
                }
                
                dp[i][j]=max + land[i][j];
            }
        }    

//         System.out.println(Arrays.toString(dp[dp.length-3]));
//         System.out.println(Arrays.toString(dp[dp.length-2]));
//         System.out.println(Arrays.toString(dp[dp.length-1]));
        
        
        return Arrays.stream(dp[dp.length - 1]).max().getAsInt();
    }
}