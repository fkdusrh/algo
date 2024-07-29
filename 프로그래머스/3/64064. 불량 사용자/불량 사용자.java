import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    static boolean[] visited; // 방문 배열
    static HashSet<String> combinations; // 가능한 조합을 저장할 HashSet
    
    public static int solution(String[] userIds, String[] bannedIds) {
        visited = new boolean[userIds.length];
        combinations = new HashSet<>();
        
        // '*'를 '.'로 변환하여 정규식으로 사용
        for (int i = 0; i < bannedIds.length; i++) {
            bannedIds[i] = bannedIds[i].replace('*', '.');
        }
        
        findCombinations(0, "", bannedIds, userIds); // 조합 찾기
        
        return combinations.size();
    }
    
    private static void findCombinations(int depth, String current, String[] bannedIds, String[] userIds) {
        if (depth == bannedIds.length) { // 모든 불량 사용자 ID에 대해 조합이 완성되었을 때
            String[] resultArray = current.trim().split(" ");
            Arrays.sort(resultArray);
            
            StringBuilder sb = new StringBuilder();
            for (String s : resultArray) {
                sb.append(s);
            }
            
            combinations.add(sb.toString());
            return;
        }
        
        for (int i = 0; i < userIds.length; i++) { // 사용자 ID 조합 생성
            if (visited[i] || !userIds[i].matches(bannedIds[depth])) {
                continue;
            }
            
            visited[i] = true;
            findCombinations(depth + 1, current + userIds[i] + " ", bannedIds, userIds);
            visited[i] = false;
        }
    }
}
