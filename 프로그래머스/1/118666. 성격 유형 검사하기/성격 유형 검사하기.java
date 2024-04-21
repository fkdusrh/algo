import java.util.*;
class Solution {
     public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < choices.length; i++) {
            char first = survey[i].charAt(0);   // 첫 번째 문자 (선택지 1~3에 해당)
            char second = survey[i].charAt(1);  // 두 번째 문자 (선택지 5~7에 해당)
            
            if (choices[i] > 4) {
                map.put(second, map.getOrDefault(second, 0) + (choices[i] - 4));
            } else if (choices[i] < 4) {
                map.put(first, map.getOrDefault(first, 0) + (4 - choices[i]));
            }
            // choices[i] == 4인 경우 어떤 점수도 추가하지 않음
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? 'R' : 'T');
        sb.append(map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? 'C' : 'F');
        sb.append(map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? 'J' : 'M');
        sb.append(map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? 'A' : 'N');
        
        return sb.toString();
    }
}