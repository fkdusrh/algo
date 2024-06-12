import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> uniquePaths = new HashSet<>();
        
        int currentY = 0, currentX = 0;
        int previousY = 0, previousX = 0;
        
        for (char direction : dirs.toCharArray()) {
            switch (direction) {
                case 'U':
                    currentY--;
                    break;
                case 'D':
                    currentY++;
                    break;
                case 'R':
                    currentX++;
                    break;
                case 'L':
                    currentX--;
                    break;
            }
            
            if (currentY < -5 || currentX < -5 || currentY > 5 || currentX > 5) {
                currentY = previousY;
                currentX = previousX;
                continue;
            }
            
            int[][] path = {{currentY, currentX}, {previousY, previousX}};
            Arrays.sort(path, (a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            });
            
            uniquePaths.add(path[0][0] + " " + path[0][1] + " " + path[1][0] + " " + path[1][1]);
            
            previousY = currentY;
            previousX = currentX;
        }
        
        return uniquePaths.size();
    }
}
