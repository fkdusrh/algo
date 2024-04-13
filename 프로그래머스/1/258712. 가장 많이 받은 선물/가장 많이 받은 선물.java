
/**
 1. 선물을 많이 받은 쪽이 선물을 받는다.
 2. 서로 선물을 주고받지 않거나, 횟수가 같다면 
            선물지수 더 큰사람 <- 작은사람
            선물지수: 이번달까지 (친구들에게 준 선물 수) - (받은 수)
            선물지수가 같다면 다음달에 주고받지 않는다.
 3. 다음달에 가장 많은 선물을 받는 친구는?
 
 입력: 이름배열, 선물 주고받은 배열
 출력: 다음달 가장 많은 선물을 받는 친구의 선물 

*/
import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        Map<String, Integer> friendNum = new HashMap<>();
        
        for (int i = 0; i < n; i++) 
            friendNum.put(friends[i], i);
        
        int[][] record = new int[n][n];
        int[] point = new int[n];
        
        for (String gift : gifts) {
            String[] g = gift.split(" ");
            int from = friendNum.get(g[0]);
            int to = friendNum.get(g[1]);

            record[from][to]++; 
            point[from]++; 
            point[to]--;
        }

        int[] willGive = new int[n];
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (record[i][j] > record[j][i]) { 
                    willGive[i]++;
                    continue;
                }
                if (record[i][j] < record[j][i]) {
                    willGive[j]++;
                    continue;
                } 
                
                if (point[i] > point[j]) {
                    willGive[i]++;
                    continue;
                }
                if (point[i] < point[j]) {
                    willGive[j]++;
                }
                
            }
        }
         return Arrays.stream(willGive).max().orElse(0);

    }
}