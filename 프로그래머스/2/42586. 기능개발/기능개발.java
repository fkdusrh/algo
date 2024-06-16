import java.util.*;

class Solution {
    public ArrayList solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> workDaysQueue = new LinkedList<>();
        
        for(int i = 0; i < progresses.length; i++) {
            workDaysQueue.add((int)Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }
        
        while(!workDaysQueue.isEmpty()) {
            int currentWorkDays = workDaysQueue.poll();
            int deployCount = 1;
            
            while(!workDaysQueue.isEmpty() && workDaysQueue.peek() <= currentWorkDays) {
                workDaysQueue.poll();
                deployCount++;
            }
            result.add(deployCount);
        }

        return result;
    }
}
