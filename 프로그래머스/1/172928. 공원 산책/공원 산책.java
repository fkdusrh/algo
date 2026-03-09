import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        int curRowIdx=0,curColIdx=0;
        int[][] directions = {{-1,0}, {1,0},{0,-1},{0,1}};
        int width = park[0].length();
        int height = park.length;
        Map<Character, Integer> hm = new HashMap<>();
        hm.put('N',0);
        hm.put('S',1);
        hm.put('W',2);
        hm.put('E',3);
        
        char[][] map = new char[park.length][park[0].length()];
        
        for(int i=0;i<height;i++){
            String p = park[i];
            
            for(int j=0;j<width;j++){
                char c = p.charAt(j);
                map[i][j] = c;
                
                if(c == 'S'){
                    curRowIdx = i;
                    curColIdx = j;
                }
            }
        }
        
        for(int i=0;i<routes.length;i++){
            char op = routes[i].charAt(0);
            int dis = routes[i].charAt(2) - '0';
            int[] direction = directions[hm.get(op)];
            
            int nextRowIdx = curRowIdx + direction[0] * dis;
            int nextColIdx = curColIdx + direction[1] * dis;
            
            if(nextRowIdx <0 || nextRowIdx >= height)
                continue;
            if(nextColIdx <0 || nextColIdx >= width)
                continue;
            
            boolean available = true;
            for(int j=curRowIdx; ; j += direction[0]){
                if(map[j][curColIdx] == 'X')
                    available = false;
                if(j == nextRowIdx)
                    break;
            }
            
            for(int j=curColIdx; ; j += direction[1]){
                if(map[curRowIdx][j] == 'X')
                    available = false;
                if(j == nextColIdx)
                    break;
            }
            
            if(!available)
                continue;
            
            curRowIdx += direction[0] * dis;
            curColIdx += direction[1] * dis;
            
        }
        
        return new int[]{curRowIdx, curColIdx};
    }
}