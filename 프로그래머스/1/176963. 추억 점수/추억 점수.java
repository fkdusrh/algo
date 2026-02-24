import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> hm = new HashMap<>();
        
        for(int i=0;i<name.length;i++){
            hm.put(name[i],yearning[i]);
        }
        
        for(int i=0;i<photo.length;i++){
            int score = 0;
            for(int j=0;j<photo[i].length;j++){
                score += hm.getOrDefault(photo[i][j] , 0);
            }
            answer[i]=score;
        }
        
        return answer;
    }
}


/*
그리워하는 사람은 100명 이하
사람 이름은 7자 이하
점수는 100점 이하

사진은 100장 이하
사진당 100명 이하

*/