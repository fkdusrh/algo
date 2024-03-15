import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0;i<commands.length;i++){//0,1,2
            int[] copyArr = Arrays.copyOf(array,array.length);

            for(int j=commands[i][0]-1;j<commands[i][1];j++){
                System.out.println("j: "+j);

                for(int k=j+1;k<commands[i][1];k++){
                    if(copyArr[j]>copyArr[k]){
                        int tmp = copyArr[k];
                        copyArr[k]=copyArr[j];
                        copyArr[j]=tmp;
                    }
                }

            }
            answer[i]=copyArr[commands[i][0]-1+commands[i][2]-1];
        }

        return answer;
    }
}