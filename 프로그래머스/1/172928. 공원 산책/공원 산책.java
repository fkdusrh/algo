import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int r=0,c=0;
        int width = park[0].length();
        int height = park.length;
        
        Map<Character, int[]> hm = new HashMap<>();
        hm.put('N',new int[]{-1,0});
        hm.put('S',new int[]{1,0});
        hm.put('W',new int[]{0,-1});
        hm.put('E',new int[]{0,1});
        
        char[][] map = new char[park.length][park[0].length()];
        
        for(int i=0;i<height;i++){
            String p = park[i];
            
            for(int j=0;j<width;j++){
                char letter = p.charAt(j);
                map[i][j] = letter;
                
                if(letter == 'S'){
                    r = i;
                    c = j;
                }
            }
        }
        
        for(int i=0;i<routes.length;i++){
            char op = routes[i].charAt(0);
            int dis = routes[i].charAt(2) - '0';
            
            int dr = hm.get(op)[0];
            int dc = hm.get(op)[1];
            boolean canMove = true;
            
            int nr = r;
            int nc = c;
            
            for(int j=0;j<dis;j++){
                nr += dr;
                nc += dc;
                
                if(nr < 0 || nc < 0 || nr >= height || nc >= width){
                    canMove = false;
                    break;
                }
                
                if(map[nr][nc] == 'X'){
                    canMove = false;
                    break;
                }
            }
            
            if(canMove){
                r += dr * dis;
                c += dc * dis;
            }
        }
        
        return new int[]{r, c};
    }
}