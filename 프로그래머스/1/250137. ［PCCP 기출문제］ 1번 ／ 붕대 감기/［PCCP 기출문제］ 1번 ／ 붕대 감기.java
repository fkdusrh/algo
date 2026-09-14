import java.util.*;
class Solution {//4:45
    public int solution(int[] bandage, int health, int[][] attacks) {
        final int MAX_HEALTH = health;
        int prevTime = 0;

        for(int[] attack:attacks){
            int term = attack[0] - prevTime-1;
            prevTime = attack[0];
            
            if(term >= 1){
                health += term * bandage[1];
                health += term / bandage[0] * bandage[2];
            }
            
            if(health > MAX_HEALTH)
                health = MAX_HEALTH;

            health -= attack[1];
            
            if(health < 1)
                return -1;
        }
        
        return health;
    }
}