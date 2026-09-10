import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] curPosition = new int[2];
        
        HashMap<String, int[]> dir = new HashMap<>();
        dir.put("W",new int[]{0,-1});
        dir.put("E",new int[]{0,1});
        dir.put("N",new int[]{-1,0});
        dir.put("S",new int[]{1,0});
        
        char[][] map = new char[park.length][park[0].length()];
        
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[0].length();j++){
                map[i][j] = park[i].charAt(j);
                
                if(map[i][j] == 'S'){
                    curPosition[0] = i;
                    curPosition[1] = j;
                }
            }
        }
        
        System.out.println(curPosition[0]+"/"+curPosition[1]);
        
        for(String route:routes){
            String[] info = route.split(" ");
            int[] direction = dir.get(info[0]);
            int distance = Integer.parseInt(info[1]);
            boolean moveable = true;
            
            for(int i=0;i<distance;i++){
                int row = curPosition[0] + direction[0]*(i+1);
                int col = curPosition[1] + direction[1] *(i+1);
                if(!isAvailable(row, col, park.length,park[0].length()) || map[row][col] == 'X'){
                    moveable = false;
                    break;
                }
            }
            
            System.out.println(moveable);
            
            
            if(moveable){
                System.out.println(route);
                System.out.println (distance * direction[0]+"/"+distance * direction[1]);
                curPosition[0] += distance * direction[0];
                curPosition[1] += distance * direction[1];
            }
        }
        
        return curPosition;
    }
    
    private boolean isAvailable(int row, int col, int height, int width){
        if(row<0 || col<0 || row >= height || col >= width)
            return false;
        return true;
    }
}