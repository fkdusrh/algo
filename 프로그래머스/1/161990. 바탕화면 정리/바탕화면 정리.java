class Solution {
    public int[] solution(String[] wallpaper) {
        int rowSize = wallpaper.length;
        int colSize = wallpaper[0].length();
        Point start = new Point(colSize,rowSize);
        Point end = new Point(0,0);
        
        for(int i=0;i<rowSize;i++){
            String s = wallpaper[i];
            
            for(int j=0;j<colSize;j++){
                char c = s.charAt(j);
                
                if(c=='#'){
                    if(start.x > j){
                        start.x = j;
                    }
                    if(start.y > i){
                        start.y = i;
                    }
                    if(end.x < j){
                        end.x = j;
                    }
                    if(end.y < i){
                        end.y = i;
                    }
                }
            }
        }
        return new int[] {start.y, start.x ,end.y +1, end.x+1};
    }
    
    class Point{
        int x;
        int y;
        
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}