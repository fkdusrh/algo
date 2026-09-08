import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0;i<commands.length;i++){
            int[] com = commands[i];
            int[] copied = Arrays.copyOfRange(array, com[0]-1,com[1]);
            Arrays.sort(copied);
            answer[i] = copied[com[2]-1];
            
        }
        return answer;
    }
}