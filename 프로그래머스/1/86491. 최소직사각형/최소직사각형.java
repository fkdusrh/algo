import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][0]<sizes[i][1]){
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1]=tmp;
                System.out.println("change!");
            }
        }
        
        for(int i=0;i<sizes.length;i++)
          System.out.println(Arrays.toString(sizes[i]));
        int rowMax=0,colMax=0;
        for(int i=0;i<sizes.length;i++){
            if(rowMax<sizes[i][0]){
                rowMax=sizes[i][0];
            }
            if(colMax<sizes[i][1]){
                colMax=sizes[i][1];
            }
        }
        return rowMax*colMax;
    }
}