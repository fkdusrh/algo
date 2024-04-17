import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        int[][] visited = new int[computers.length][computers.length];
        
        Stack<Integer> s = new Stack<>();
        
        for(int i=0;i<computers.length;i++){
            for(int j=0;j<computers.length;j++){
                
                if(computers[i][j]==0) 
                    continue;
                
                if(i==j) { 
                    answer++;
                    computers[i][j]=0;
                    continue;
                }
                
                if(computers[i][j]==1){ 
                    s.push(j);
                    computers[j][i]=0; 
                }

                
                while(!s.isEmpty()){ 
                    int row = s.pop(); 
                                        
                    for(int k=0;k<computers.length;k++){
                        if(row==k) { 
                            computers[row][row]=0;
                            continue;
                        }
                        if(computers[row][k]==1){ 
                            s.push(k); 
                            computers[row][k]=0; 
                        }
                           
                    }
                }
            }
        }
        return answer;
    }
}